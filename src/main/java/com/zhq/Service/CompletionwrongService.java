package com.zhq.Service;

import com.zhq.pojo.Completionwrong;

import java.util.List;

public interface CompletionwrongService{
    int addcompletionwrong(Completionwrong completionwrong);
    int findcompletionwrongquestion(String question);
    List<Completionwrong> allcompletionwrong(String subject,String account_user_name);
    int deletecompletionwrong(int id);
}
