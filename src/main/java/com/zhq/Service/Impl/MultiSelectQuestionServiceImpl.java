package com.zhq.Service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhq.Service.MultiSelectQuestionService;
import com.zhq.mapper.MultiSelectQuestionMapper;
import com.zhq.pojo.MultiSelectQuestion;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenchenchen
 * @create 2023-01-18 13:36
 */
@Service
public class MultiSelectQuestionServiceImpl implements MultiSelectQuestionService {

    @Resource
    private MultiSelectQuestionMapper multiSelectQuestionMapper;


    @Override
    public Map<String, Object> findAllMultiSelectQuestion(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<MultiSelectQuestion> allMultiSelectQuestion = multiSelectQuestionMapper.findAllMultiSelectQuestion();
        PageInfo<MultiSelectQuestion> pageInfo = new PageInfo<>(allMultiSelectQuestion);
        Map<String,Object> map=new HashMap<>();
        map.put("currentPage",pageInfo.getPageNum());
        map.put("totalCount",pageInfo.getTotal());
        map.put("totalPage",pageInfo.getPages());
        map.put("record",allMultiSelectQuestion);
        return map;
    }

    @Override
    public void insertBatchMultiSelectQuestion(List<MultiSelectQuestion> multiSelectQuestions) {
        multiSelectQuestionMapper.insertBatchMultiSelectQuestion(multiSelectQuestions);
    }

    @Override
    public void insertOneQuestion(MultiSelectQuestion multiSelectQuestion) {
        multiSelectQuestionMapper.insertOneQuestion(multiSelectQuestion);
    }

    @Override
    public MultiSelectQuestion findMultiSelectQuestionByQuestionId(Integer questionId) {
        return multiSelectQuestionMapper.findMultiSelectQuestionByQuestionId(questionId);
    }

    @Override
    public void updateMultiSelectQuestion(MultiSelectQuestion multiSelectQuestion) {
        multiSelectQuestionMapper.updateMultiSelectQuestion(multiSelectQuestion);
    }

    @Override
    public void deleteMultiSelectQuestion(Integer questionId) {
        multiSelectQuestionMapper.deleteMultiSelectQuestion(questionId);
    }
}
