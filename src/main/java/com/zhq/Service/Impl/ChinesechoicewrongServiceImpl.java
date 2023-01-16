package com.zhq.Service.Impl;

import com.zhq.Service.ChinesechoicewrongService;
import com.zhq.mapper.ChinesechoicewrongMapper;
import com.zhq.pojo.Chinesechoicewrong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChinesechoicewrongServiceImpl implements ChinesechoicewrongService {
    @Autowired
    ChinesechoicewrongMapper chinesechoicewrongMapper;

    @Override
    public int addChinesechoicewrong(Chinesechoicewrong chinesechoicewrong) {
        return chinesechoicewrongMapper.addChinesechoicewrong(chinesechoicewrong);
    }

    @Override
    public int findChinesechoicewrong(String question) {
        return chinesechoicewrongMapper.findChinesechoicewrong(question);
    }
}
