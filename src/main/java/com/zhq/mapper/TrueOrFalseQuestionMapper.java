package com.zhq.mapper;

import com.zhq.pojo.MultiSelectQuestion;
import com.zhq.pojo.TrueOrFalseQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenchenchen
 * @create 2023-01-17 16:22
 */
@Mapper
public interface TrueOrFalseQuestionMapper {
    /**
     *
     * @return
     * @Description 查找判断题列表
     */
    List<TrueOrFalseQuestion> findAllTrueOrFalseQuestion();

    /**
     *
     * @param trueOrFalseQuestions
     * @Description 批量插入判断题
     */
    void insertBatchTrueOrFalseQuestion(@Param("trueOrFalseQuestions") List<TrueOrFalseQuestion> trueOrFalseQuestions);

    /**
     *
     * @param trueOrFalseQuestion
     * @Description 插入一条记录
     */
    void insertOneQuestion(@Param("trueOrFalseQuestion") TrueOrFalseQuestion trueOrFalseQuestion);

    /**
     *
     * @param questionId
     * @Description 根据questionId查询判断题
     */
    TrueOrFalseQuestion findTrueOrFalseQuestionId(@Param("questionId") Integer questionId);

    /**
     *
     * @param trueOrFalseQuestion
     * @Description 修改判断题
     */
    void updateTrueOrFalseQuestion(TrueOrFalseQuestion trueOrFalseQuestion);

    /**
     *
     * @param questionId
     * @Description 根据questionId删除判断题
     */
    void deleteTrueOrFalseQuestion(@Param("questionId") Integer questionId);
}
