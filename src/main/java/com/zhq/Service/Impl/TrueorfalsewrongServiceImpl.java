package com.zhq.Service.Impl;

import com.zhq.Service.TrueorfalsewrongService;
import com.zhq.mapper.TrueorfalsewrongMapper;
import com.zhq.pojo.Trueorfalsewrong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZHQ
 * @create 2023-1-25 21:06
 */

@Service
public class TrueorfalsewrongServiceImpl implements TrueorfalsewrongService {
    @Autowired
    TrueorfalsewrongMapper trueorfalsewrongMapper;
    @Override
    public void inserttrueorfalsewrong(Trueorfalsewrong trueorfalsewrong) {
        trueorfalsewrongMapper.inserttrueorfalsewrong(trueorfalsewrong);
    }

    @Override
    public int querytrueorfalsewrong(String question) {
        return trueorfalsewrongMapper.querytrueorfalsewrong(question);
    }

    @Override
    public List<Trueorfalsewrong> alltrueorfalsewrong(String subject,String account_user_name) {
        return trueorfalsewrongMapper.alltrueorfalsewrong(subject,account_user_name);
    }

    @Override
    public int deletetrueorfalsewrong(Integer id) {
        return trueorfalsewrongMapper.deletetrueorfalsewrong(id);
    }
}
