package com.zhq.Service;

import com.zhq.pojo.TrueOrFalseQuestion;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author chenchenchen
 * @create 2023-01-18 13:37
 */
public interface TrueOrFalseQuestionService {
    /**
     *
     * @return
     * @Description 查找判断题列表
     */
    Map<String,Object> findAllTrueOrFalseQuestion(Integer pageNum, Integer pageSize);

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

    /**
     *
     * @param subjectId
     * @Description 根据subjectId删除单选题
     */
    boolean deleteQuestionBySubjectId(Integer subjectId);

    /**
     *
     * @param chapterId
     * @Description 根据chapterId删除单选题
     */
    boolean deleteQuestionByChapterId(Integer chapterId);
}
