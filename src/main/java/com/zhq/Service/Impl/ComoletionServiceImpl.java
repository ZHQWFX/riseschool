package com.zhq.Service.Impl;

import com.zhq.Service.CompletionService;
import com.zhq.mapper.CompletionMapper;
import com.zhq.pojo.Completion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComoletionServiceImpl implements CompletionService {
    @Autowired
    CompletionMapper completionMapper;
    @Override
    public List<Completion> allcompletion(String subject) {
        return completionMapper.allcompletion(subject);
    }

    @Override
    public int countcompletion() {
        return completionMapper.countcompletion();
    }
}
