package com.zhq.Service.Impl;

import com.zhq.Service.*;
import com.zhq.mapper.SingleSelectQuestionMapper;
import com.zhq.mapper.SubjectMapper;
import com.zhq.pojo.Result;
import com.zhq.pojo.SingleSelectQuestion;
import com.zhq.pojo.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenchenchen
 * @create 2023-01-26 20:51
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Resource
    private SubjectMapper subjectMapper;

    @Resource
    private SingleSelectQuestionService singleSelectQuestionService;

    @Resource
    private MultiSelectQuestionService multiSelectQuestionService;

    @Resource
    private TrueOrFalseQuestionService trueOrFalseQuestionService;

    @Resource
    private ChapterService chapterService;

    @Override
    public List<Subject> findSubjectByAccountUser(String accountUser) {
        return subjectMapper.findSubjectByAccountUser(accountUser);
    }

    @Override
    public boolean insertSubject(Subject subject) {
        return subjectMapper.insertSubject(subject)>0;
    }

    @Transactional
    @Override
    public boolean removeSubjectBySubjectId(Integer subjectId) {
        singleSelectQuestionService.deleteQuestionBySubjectId(subjectId);
        multiSelectQuestionService.deleteQuestionBySubjectId(subjectId);
        trueOrFalseQuestionService.deleteQuestionBySubjectId(subjectId);
        chapterService.removeChapterBySubjectId(subjectId);
        return subjectMapper.removeSubjectBySubjectId(subjectId)>0;
    }

    @Override
    public boolean updateSubjectName(Integer subjectId, String subjectName) {
        return subjectMapper.updateSubjectName(subjectId, subjectName)>0;
    }
}
