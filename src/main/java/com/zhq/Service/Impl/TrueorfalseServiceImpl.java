package com.zhq.Service.Impl;

import com.zhq.Service.TrueorfalseService;
import com.zhq.mapper.TrueorfalseMapper;
import com.zhq.pojo.Trueorfalse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrueorfalseServiceImpl implements TrueorfalseService {
    @Autowired
    TrueorfalseMapper trueorfalseMapper;

    @Override
    public List<Trueorfalse> alltrueorfalse(String subject) {
        return trueorfalseMapper.alltrueorfalse(subject);
    }
}
