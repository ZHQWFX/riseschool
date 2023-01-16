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
     * @param singleSelectQuestionList
     * @Description 批量添加题目
     */
    void insertBatchQuestion(@Param("singleSelectQuestionList") List<SingleSelectQuestion> singleSelectQuestionList);
}
