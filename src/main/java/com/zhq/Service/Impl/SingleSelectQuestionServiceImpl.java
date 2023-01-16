package com.zhq.Service.Impl;

import com.zhq.Service.SingleSelectQuestionService;
import com.zhq.mapper.SingleSelectQuestionMapper;
import com.zhq.pojo.SingleSelectQuestion;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xmlbeans.XmlException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chenchenchen
 * @create 2023-01-16 16:54
 */
@Service
public class SingleSelectQuestionServiceImpl implements SingleSelectQuestionService {

    @Resource
    private SingleSelectQuestionMapper singleSelectQuestionMapper;

    @Override
    public void insertBatchQuestion(MultipartFile multipartFile) {
        try {
            String originalFilename = multipartFile.getOriginalFilename();
            if (originalFilename.endsWith(".doc")) {
                WordExtractor re = new WordExtractor(multipartFile.getInputStream());
                String text = re.getText();
                List<SingleSelectQuestion> singleSelectQuestionList = parseText(text);
                singleSelectQuestionMapper.insertBatchQuestion(singleSelectQuestionList);
            } else if (originalFilename.endsWith(".docx")) {
                XWPFDocument xwpfDocument = new XWPFDocument(multipartFile.getInputStream());
                POIXMLTextExtractor poixmlTextExtractor = new XWPFWordExtractor(xwpfDocument);
                String text = poixmlTextExtractor.getText();
                List<SingleSelectQuestion> singleSelectQuestionList = parseText(text);
                singleSelectQuestionMapper.insertBatchQuestion(singleSelectQuestionList);
            } else {
                System.out.println("这不是一个word文件");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean isQuestion(String str) {
        Pattern pattern = Pattern.compile("[0-9].*");
        Matcher isNum = pattern.matcher(str.trim());
        return isNum.matches();
    }

    public boolean isOptions(String str) {
        Pattern pattern = Pattern.compile("[A-D].*");
        Matcher isOptions = pattern.matcher(str.trim());
        return isOptions.matches();
    }
    public boolean isAnswer(String str){
        str=str.trim();
        if(str.startsWith("答案:")||str.startsWith("答案：")){
            return true;
        }
        return false;
    }
    public boolean isAnalysis(String str){
        str=str.trim();
        if(str.startsWith("解析:")||str.startsWith("解析：")){
            return true;
        }
        return false;
    }
    public List<SingleSelectQuestion> parseText(String text){
        String[] strings = text.split("\n");
        List<SingleSelectQuestion> singleSelectQuestionList=new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            if (isQuestion(strings[i])) {
                String question=strings[i];
                i++;
                StringBuilder options = new StringBuilder();
                StringBuilder answers=new StringBuilder();
                StringBuilder analysis=new StringBuilder();
                String optionA = "";
                String optionB = "";
                String optionC = "";
                String optionD = "";
                if(i>=strings.length){
                    break;
                }
                while (isOptions(strings[i])&&!isAnswer(strings[i])&&
                       !isAnalysis(strings[i])&&!isQuestion(strings[i])) {
                    options.append(strings[i++]);
                }
                while(!isOptions(strings[i])&&isAnswer(strings[i])&&
                        !isAnalysis(strings[i])&&!isQuestion(strings[i])){
                    answers.append(strings[i++]);
                }
                while(!isOptions(strings[i])&&!isAnswer(strings[i])&&
                        isAnalysis(strings[i])&&!isQuestion(strings[i])){
                    analysis.append(strings[i++]);
                }
                i--;
                if(options.length()>0){
                    optionA=options.substring(options.indexOf("A"),options.indexOf("B"));
                    optionB=options.substring(options.indexOf("B"),options.indexOf("C"));
                    optionC=options.substring(options.indexOf("C"),options.indexOf("D"));
                    optionD=options.substring(options.indexOf("D"));
                    SingleSelectQuestion singleSelectQuestion = new SingleSelectQuestion(null,
                            question, optionA, optionB, optionC, optionD, new String(answers),
                            "近代史", "第一章", "chenchenchen", new String(analysis));
                    singleSelectQuestionList.add(singleSelectQuestion);
                }
            }
        }
        return singleSelectQuestionList;
    }
}
