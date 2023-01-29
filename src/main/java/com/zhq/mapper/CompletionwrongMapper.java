package com.zhq.mapper;

import com.zhq.pojo.Completionwrong;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompletionwrongMapper {
    int addcompletionwrong(Completionwrong completionwrong);
    int findcompletionwrongquestion(String question);
    List<Completionwrong> allcompletionwrong(String subject,String account_user_name);
    int deletecompletionwrong(int id);
}
