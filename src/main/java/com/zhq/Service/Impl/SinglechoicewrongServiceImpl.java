package com.zhq.Service.Impl;


import com.zhq.Service.SinglechoicewrongService;
import com.zhq.mapper.SinglechoicewrongMapper;
import com.zhq.pojo.Singlechoicewrong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SinglechoicewrongServiceImpl implements SinglechoicewrongService {
    @Autowired
    SinglechoicewrongMapper singlechoicewrongMapper;

    @Override
    public int addsinglechoicewrong(Singlechoicewrong singlechoicewrong) {
        return singlechoicewrongMapper.addsinglechoicewrong(singlechoicewrong);
    }

    @Override
    public int findsinglechoicewrong(String question,String subject) {
        return singlechoicewrongMapper.findsinglechoicewrong(question,subject);
    }

    @Override
    public void deletesinglechoicewrong(int id) {
        singlechoicewrongMapper.deletesinglechoicewrong(id);
    }

    @Override
    public List<Singlechoicewrong> allsinglechoicewrong(String subject,String account_user_name) {
        return singlechoicewrongMapper.allsinglechoicewrong(subject,account_user_name);
    }
}
