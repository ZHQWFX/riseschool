package com.zhq.Service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhq.Service.SingleSelectQuestionService;
import com.zhq.mapper.SingleSelectQuestionMapper;
import com.zhq.pojo.SingleSelectQuestion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenchenchen
 * @create 2023-01-16 16:54
 */
@Service
@Slf4j
public class SingleSelectQuestionServiceImpl implements SingleSelectQuestionService {

    @Resource
    private SingleSelectQuestionMapper singleSelectQuestionMapper;

    @Override
    public Map<String, Object> findSingleSelectQuestionList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SingleSelectQuestion> singleSelectQuestionList = singleSelectQuestionMapper.findSingleSelectQuestionList();
        PageInfo<SingleSelectQuestion> pageInfo = new PageInfo<>(singleSelectQuestionList);
        Map<String, Object> map = new HashMap<>();
        map.put("currentPage", pageInfo.getPageNum());
        map.put("totalCount", pageInfo.getTotal());
        map.put("totalPages", pageInfo.getPages());
        map.put("records", singleSelectQuestionList);
        return map;
    }

    @Override
    public void insertBatchQuestion(List<SingleSelectQuestion> singleSelectQuestionList) {
        singleSelectQuestionMapper.insertBatchQuestion(singleSelectQuestionList);
    }

    @Override
    public void insertOneQuestion(SingleSelectQuestion singleSelectQuestion) {
        singleSelectQuestionMapper.insertOneQuestion(singleSelectQuestion);
    }

    @Override
    public SingleSelectQuestion findQuestionByQuestionId(Integer questionId) {
        SingleSelectQuestion singleSelectQuestion = singleSelectQuestionMapper.findQuestionByQuestionId(questionId);
        return singleSelectQuestion;
    }

    @Override
    public void updateByQuestion(SingleSelectQuestion singleSelectQuestion) {
        singleSelectQuestionMapper.updateByQuestion(singleSelectQuestion);
    }

    @Override
    public void deleteQuestionByQuestionId(Integer questionId) {
        singleSelectQuestionMapper.deleteQuestionByQuestionId(questionId);
    }

    @Override
    public boolean deleteQuestionBySubjectId(Integer subjectId) {
        return singleSelectQuestionMapper.deleteQuestionBySubjectId(subjectId)>0;
    }

    @Override
    public boolean deleteQuestionByChapterId(Integer chapterId) {
        return singleSelectQuestionMapper.deleteQuestionByChapterId(chapterId)>0;
    }

}
