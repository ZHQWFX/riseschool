package com.zhq.mapper;

import com.zhq.pojo.MultiSelectQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenchenchen
 * @create 2023-01-17 16:20
 */
@Mapper
public interface MultiSelectQuestionMapper {
    /**
     *
     * @return
     * @Description 查找多选题列表
     */
    List<MultiSelectQuestion> findAllMultiSelectQuestion();

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
