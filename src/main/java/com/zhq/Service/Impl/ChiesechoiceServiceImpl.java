package com.zhq.Service.Impl;

import com.zhq.Service.ChinesechoiceService;
import com.zhq.mapper.ChinesechoiceMapper;
import com.zhq.pojo.Chinesechoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiesechoiceServiceImpl implements ChinesechoiceService {
    @Autowired
    ChinesechoiceMapper chinesechoiceMapper;

    @Override
    public int addchinesechoice(Chinesechoice chinesechoice) {
        return chinesechoiceMapper.addchinesechoice(chinesechoice);
    }

    @Override
    public List<Chinesechoice> allchinesechoice(String type) {
        return chinesechoiceMapper.allchinesechoice(type);
    }
}
