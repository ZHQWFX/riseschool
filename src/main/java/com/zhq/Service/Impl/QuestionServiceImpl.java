package com.zhq.Service.Impl;

import com.zhq.Service.MultiSelectQuestionService;
import com.zhq.Service.QuestionService;
import com.zhq.Service.SingleSelectQuestionService;
import com.zhq.Service.TrueOrFalseQuestionService;
import com.zhq.pojo.MultiSelectQuestion;
import com.zhq.pojo.Question;
import com.zhq.pojo.SingleSelectQuestion;
import com.zhq.pojo.TrueOrFalseQuestion;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chenchenchen
 * @create 2023-01-18 13:30
 */
@Slf4j
@Service
@Transactional(timeout = 3)
public class QuestionServiceImpl implements QuestionService {

    @Resource
    private SingleSelectQuestionService singleSelectQuestionService;

    @Resource
    private MultiSelectQuestionService multiSelectQuestionService;

    @Resource
    private TrueOrFalseQuestionService trueOrFalseQuestionService;

    @Override
    public void insertBatchQuestion(MultipartFile multipartFile) {
        try {
            String originalFilename = multipartFile.getOriginalFilename();
            if (originalFilename.endsWith(".doc")) {
                WordExtractor re = new WordExtractor(multipartFile.getInputStream());
                String text = re.getText();
                Question question = parseText(text);
                List<SingleSelectQuestion> singleSelectQuestionList = question.getSingleSelectQuestions();
                List<MultiSelectQuestion> multiSelectQuestionList = question.getMultiSelectQuestions();
                List<TrueOrFalseQuestion> trueOrFalseQuestionList = question.getTrueOrFalseQuestions();
                if (singleSelectQuestionList != null && singleSelectQuestionList.size() > 0) {
                    singleSelectQuestionService.insertBatchQuestion(singleSelectQuestionList);
                }
                if (multiSelectQuestionList!=null&&multiSelectQuestionList.size() > 0) {
                    multiSelectQuestionService.insertBatchMultiSelectQuestion(multiSelectQuestionList);
                }
                if (trueOrFalseQuestionList!=null&&trueOrFalseQuestionList.size() > 0) {
                    trueOrFalseQuestionService.insertBatchTrueOrFalseQuestion(trueOrFalseQuestionList);
                }
            } else if (originalFilename.endsWith(".docx")) {
                XWPFDocument xwpfDocument = new XWPFDocument(multipartFile.getInputStream());
                POIXMLTextExtractor poixmlTextExtractor = new XWPFWordExtractor(xwpfDocument);
                String text = poixmlTextExtractor.getText();
                Question question = parseText(text);
                List<SingleSelectQuestion> singleSelectQuestionList = question.getSingleSelectQuestions();
                List<MultiSelectQuestion> multiSelectQuestionList = question.getMultiSelectQuestions();
                List<TrueOrFalseQuestion> trueOrFalseQuestionList = question.getTrueOrFalseQuestions();
                if (singleSelectQuestionList != null && singleSelectQuestionList.size() > 0) {
                    singleSelectQuestionService.insertBatchQuestion(singleSelectQuestionList);
                }
                if (multiSelectQuestionList!=null&&multiSelectQuestionList.size() > 0) {
                    multiSelectQuestionService.insertBatchMultiSelectQuestion(multiSelectQuestionList);
                }
                if (trueOrFalseQuestionList!=null&&trueOrFalseQuestionList.size() > 0) {
                    trueOrFalseQuestionService.insertBatchTrueOrFalseQuestion(trueOrFalseQuestionList);
                }

            } else {
                System.out.println("这不是一个word文件");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Question parseText(String text) {
        String[] strings = text.split("\n");
        Question question = new Question();
        int type = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].contains("单项选择题") || strings[i].contains("单选题")) {
                type = 1;
                log.info("单选题开始");
            } else if (strings[i].contains("多选题") || strings[i].contains("多项选择题")) {
                type = 2;
                log.info("多选题开始");
            } else if (strings[i].contains("判断题")) {
                type = 3;
                log.info("判断题开始");
            } else if (strings[i].contains("填空题")) {
                type = 4;
                log.info("填空题开始");
            }
            switch (type) {
                case 1:
                    i = parseSinglSelectQuestion(strings, i, question);
                    break;
                case 2:
                    i = parseMultiSelectQuestion(strings, i, question);
                    break;
                case 3:
                    i = parseTrueOrFalseQuestion(strings, i, question);
                    break;
//                case 4:
//                    i = parseSingleQuestion(strings, i, singleSelectQuestionList);
//                    break;
                default:
                    break;
            }
            if (i >= strings.length) {
                break;
            }
        }
        return question;
    }

    private int parseSinglSelectQuestion(String[] strings, Integer i,
                                         Question questions) {
        if (isQuestion(strings[i])) {
            String question = strings[i];
            i++;
            StringBuilder options = new StringBuilder();
            StringBuilder answers = new StringBuilder();
            StringBuilder analysis = new StringBuilder();
            String optionA = "";
            String optionB = "";
            String optionC = "";
            String optionD = "";
            if (i >= strings.length) {
                return i;
            }
            while (isOptions(strings[i]) && !isAnswer(strings[i]) &&
                    !isAnalysis(strings[i]) && !isQuestion(strings[i])) {
                options.append(strings[i++]);
            }
            while (!isOptions(strings[i]) && isAnswer(strings[i]) &&
                    !isAnalysis(strings[i]) && !isQuestion(strings[i])) {
                answers.append(strings[i++]);
            }
            while (!isOptions(strings[i]) && !isAnswer(strings[i]) &&
                    isAnalysis(strings[i]) && !isQuestion(strings[i])) {
                analysis.append(strings[i++]);
            }
            i--;
            if (options.length() > 0) {
                optionA = options.substring(options.indexOf("A"), options.indexOf("B"));
                optionB = options.substring(options.indexOf("B"), options.indexOf("C"));
                optionC = options.substring(options.indexOf("C"), options.indexOf("D"));
                optionD = options.substring(options.indexOf("D"));
                SingleSelectQuestion singleSelectQuestion = new SingleSelectQuestion(null,
                        question.trim(), optionA.trim(), optionB.trim(), optionC.trim(), optionD.trim(), new String(answers),
                        "计算机", "第一章", "chenchenchen", new String(analysis)
                );
                if (questions.getSingleSelectQuestions() == null) {
                    List<SingleSelectQuestion> list = new ArrayList<>();
                    questions.setSingleSelectQuestions(list);
                }
                questions.getSingleSelectQuestions().add(singleSelectQuestion);
            }
        }
        return i;
    }

    private int parseMultiSelectQuestion(String[] strings, Integer i,
                                         Question questions) {
        if (isQuestion(strings[i])) {
            String question = strings[i];
            i++;
            StringBuilder options = new StringBuilder();
            StringBuilder answers = new StringBuilder();
            StringBuilder analysis = new StringBuilder();
            String optionA = "";
            String optionB = "";
            String optionC = "";
            String optionD = "";
            if (i >= strings.length) {
                return i;
            }
            while (isOptions(strings[i]) && !isAnswer(strings[i]) &&
                    !isAnalysis(strings[i]) && !isQuestion(strings[i])) {
                options.append(strings[i++]);
            }
            while (!isOptions(strings[i]) && isAnswer(strings[i]) &&
                    !isAnalysis(strings[i]) && !isQuestion(strings[i])) {
                answers.append(strings[i++]);
            }
            while (!isOptions(strings[i]) && !isAnswer(strings[i]) &&
                    isAnalysis(strings[i]) && !isQuestion(strings[i])) {
                analysis.append(strings[i++]);
            }
            i--;
            if (options.length() > 0) {
                optionA = options.substring(options.indexOf("A"), options.indexOf("B"));
                optionB = options.substring(options.indexOf("B"), options.indexOf("C"));
                optionC = options.substring(options.indexOf("C"), options.indexOf("D"));
                optionD = options.substring(options.indexOf("D"));
                MultiSelectQuestion multiSelectQuestion = new MultiSelectQuestion(null,
                        question.trim(), optionA.trim(), optionB.trim(), optionC.trim(), optionD.trim(), new String(answers),
                        "计算机", "第一章", "chenchenchen", new String(analysis)
                );
                if (questions.getMultiSelectQuestions() == null) {
                    List<MultiSelectQuestion> list = new ArrayList<>();
                    questions.setMultiSelectQuestions(list);
                }
                questions.getMultiSelectQuestions().add(multiSelectQuestion);
            }
        }
        return i;
    }

    private int parseTrueOrFalseQuestion(String[] strings, Integer i,
                                         Question questions) {
        if (isQuestion(strings[i])) {
            String question = strings[i];
            i++;
            StringBuilder answers = new StringBuilder();
            StringBuilder analysis = new StringBuilder();
            if (i >= strings.length) {
                return i;
            }
            while (isAnswer(strings[i]) && !isAnalysis(strings[i]) &&
                    !isQuestion(strings[i])) {
                answers.append(strings[i++]);
            }
            while (!isAnswer(strings[i]) && isAnalysis(strings[i]) &&
                    !isQuestion(strings[i])) {
                analysis.append(strings[i++]);
            }
            i--;
            if (question.length() > 0) {
                TrueOrFalseQuestion trueOrFalseQuestion = new TrueOrFalseQuestion(null,
                        question.trim(), new String(answers), "计算机", "第一章",
                        "chenchenchen", new String(analysis));
                if(questions.getTrueOrFalseQuestions()==null){
                    List<TrueOrFalseQuestion> list=new ArrayList<>();
                    questions.setTrueOrFalseQuestions(list);
                }
                questions.getTrueOrFalseQuestions().add(trueOrFalseQuestion);
            }
        }
        return i;
    }

    private boolean isQuestion(String str) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher isNum = pattern.matcher(str.trim());
        return isNum.matches();
    }

    private boolean isOptions(String str) {
        Pattern pattern = Pattern.compile("[A-D].*");
        Matcher isOptions = pattern.matcher(str.trim());
        return isOptions.matches();
    }

    private boolean isAnswer(String str) {
        str = str.trim();
        if (str.startsWith("答案:") || str.startsWith("答案：")) {
            return true;
        }
        return false;
    }

    private boolean isAnalysis(String str) {
        str = str.trim();
        if (str.startsWith("解析:") || str.startsWith("解析：")) {
            return true;
        }
        return false;
    }
}
