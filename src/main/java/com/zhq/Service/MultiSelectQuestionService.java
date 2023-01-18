package com.zhq.Service;

import com.zhq.pojo.MultiSelectQuestion;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author chenchenchen
 * @create 2023-01-18 13:35
 */
public interface MultiSelectQuestionService {
    /**
     *
     * @return
     * @Description 查找多选题列表
     */
    Map<String,Object> findAllMultiSelectQuestion(Integer pageNum, Integer pageSize);

    /**
     *
     * @param multiSelectQuestions
     * @Description 批量插入多选题
     */
    void insertBatchMultiSelectQuestion(@Param("multiSelectQuestions") List<MultiSelectQuestion> multiSelectQuestions);

    /**
     *
     * @param multiSelectQuestion
     * @Description 插入一条记录
     */
    void insertOneQuestion(@Param("multiSelectQuestion") MultiSelectQuestion multiSelectQuestion);

    /**
     *
     * @param questionId
     * @Description 根据questionId查询多选题
     */
    MultiSelectQuestion findMultiSelectQuestionByQuestionId(@Param("questionId") Integer questionId);

    /**
     *
     * @param multiSelectQuestion
     * @Description 修改多选题
     */
    void updateMultiSelectQuestion(MultiSelectQuestion multiSelectQuestion);

    /**
     *
     * @param questionId
     * @Description 根据questionId删除多选题
     */
    void deleteMultiSelectQuestion(@Param("questionId") Integer questionId);
}
