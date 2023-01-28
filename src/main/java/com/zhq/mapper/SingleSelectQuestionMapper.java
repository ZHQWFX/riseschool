package com.zhq.mapper;

import com.zhq.pojo.SingleSelectQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenchenchen
 * @create 2023-01-16 16:42
 */
@Mapper
public interface SingleSelectQuestionMapper {

    /**
     *
     * @return
     * @Description 查询单选题列表
     */
    List<SingleSelectQuestion> findSingleSelectQuestionList();
    /**
     *
     * @param singleSelectQuestionList
     * @Description 批量添加题目
     */
    void insertBatchQuestion(@Param("singleSelectQuestionList") List<SingleSelectQuestion> singleSelectQuestionList);

    /**
     *
     * @param singleSelectQuestion
     * @Description 插入一条记录
     */
    void insertOneQuestion(@Param("singleSelectQuestion") SingleSelectQuestion singleSelectQuestion);
    /**
     *
     * @param questionId
     * @return 根据id查询单选题
     */
    SingleSelectQuestion findQuestionByQuestionId(@Param("questionId") Integer questionId);

    /**
     *
     * @param singleSelectQuestion
     * @Description 修改题库
     */
    void updateByQuestion(@Param("singleSelectQuestion") SingleSelectQuestion singleSelectQuestion);

    /**
     *
     * @param questionId
     * @Description 根据questionId删除单选题
     */
    void deleteQuestionByQuestionId(@Param("questionId") Integer questionId);

    /**
     *
     * @param subjectId
     * @Description 根据subjectId删除单选题
     */
    int deleteQuestionBySubjectId(@Param("subjectId") Integer subjectId);

    /**
     *
     * @param chapterId
     * @Description 根据chapterId删除单选题
     */
    int deleteQuestionByChapterId(@Param("chapterId") Integer chapterId);

}
