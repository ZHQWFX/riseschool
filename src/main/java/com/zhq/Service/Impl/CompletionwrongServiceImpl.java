package com.zhq.Service.Impl;

import com.zhq.Service.CompletionwrongService;
import com.zhq.mapper.CompletionwrongMapper;
import com.zhq.pojo.Completionwrong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompletionwrongServiceImpl implements CompletionwrongService {
    @Autowired
    CompletionwrongMapper completionwrongMapper;

    @Override
    public int addcompletionwrong(Completionwrong completionwrong) {
        return completionwrongMapper.addcompletionwrong(completionwrong);
    }

    @Override
    public int findcompletionwrongquestion(String question) {
        return completionwrongMapper.findcompletionwrongquestion(question);
    }

    @Override
    public List<Completionwrong> allcompletionwrong(String subject,String account_user_name){
        return completionwrongMapper.allcompletionwrong(subject,account_user_name);
    }

    @Override
    public int deletecompletionwrong(int id) {
        return completionwrongMapper.deletecompletionwrong(id);
    }
}
