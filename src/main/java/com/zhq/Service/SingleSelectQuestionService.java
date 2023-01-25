package com.zhq.Service;

import com.zhq.pojo.SingleSelectQuestion;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author chenchenchen
 * @create 2023-01-16 16:54
 */
public interface SingleSelectQuestionService {

    /**
     *
     * @return
     * @Description 查询单选题列表
     */
    Map<String,Object> findSingleSelectQuestionList(Integer pageNum,Integer pageSize);

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
}
