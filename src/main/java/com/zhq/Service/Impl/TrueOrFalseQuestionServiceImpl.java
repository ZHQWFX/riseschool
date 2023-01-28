package com.zhq.Service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhq.Service.TrueOrFalseQuestionService;
import com.zhq.mapper.TrueOrFalseQuestionMapper;
import com.zhq.pojo.TrueOrFalseQuestion;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenchenchen
 * @create 2023-01-18 13:38
 */
@Service
public class TrueOrFalseQuestionServiceImpl implements TrueOrFalseQuestionService {

    @Resource
    private TrueOrFalseQuestionMapper trueOrFalseQuestionMapper;


    @Override
    public Map<String, Object> findAllTrueOrFalseQuestion(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TrueOrFalseQuestion> trueOrFalseQuestions = trueOrFalseQuestionMapper.findAllTrueOrFalseQuestion();
        PageInfo pageInfo=new PageInfo(trueOrFalseQuestions);
        Map<String,Object> map=new HashMap<>();
        map.put("currentPage",pageInfo.getPageNum());
        map.put("totalCount",pageInfo.getTotal());
        map.put("totalPage",trueOrFalseQuestions);
        return map;
    }

    @Override
    public void insertBatchTrueOrFalseQuestion(List<TrueOrFalseQuestion> trueOrFalseQuestions) {
        trueOrFalseQuestionMapper.insertBatchTrueOrFalseQuestion(trueOrFalseQuestions);
    }

    @Override
    public void insertOneQuestion(TrueOrFalseQuestion trueOrFalseQuestion) {
        trueOrFalseQuestionMapper.insertOneQuestion(trueOrFalseQuestion);
    }

    @Override
    public TrueOrFalseQuestion findTrueOrFalseQuestionId(Integer questionId) {
        return trueOrFalseQuestionMapper.findTrueOrFalseQuestionId(questionId);
    }

    @Override
    public void updateTrueOrFalseQuestion(TrueOrFalseQuestion trueOrFalseQuestion) {
        trueOrFalseQuestionMapper.updateTrueOrFalseQuestion(trueOrFalseQuestion);
    }

    @Override
    public void deleteTrueOrFalseQuestion(Integer questionId) {
        trueOrFalseQuestionMapper.deleteTrueOrFalseQuestion(questionId);
    }

    @Override
    public boolean deleteQuestionBySubjectId(Integer subjectId) {
        return trueOrFalseQuestionMapper.deleteQuestionBySubjectId(subjectId)>0;
    }

    @Override
    public boolean deleteQuestionByChapterId(Integer chapterId) {
        return trueOrFalseQuestionMapper.deleteQuestionByChapterId(chapterId)>0;
    }
}
