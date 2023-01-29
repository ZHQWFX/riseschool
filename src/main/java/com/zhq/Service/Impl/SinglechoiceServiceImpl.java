package com.zhq.Service.Impl;

import com.zhq.Service.SinglechoiceService;
import com.zhq.mapper.SinglechoiceMapper;
import com.zhq.pojo.Singlechoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZHQ
 * @create 2023-1-27 18:05
 */
@Service
public class SinglechoiceServiceImpl implements SinglechoiceService {
    @Autowired
    SinglechoiceMapper singlechoiceMapper;

    @Override
    public int addsinglechoice(Singlechoice singlechoice) {
        return singlechoiceMapper.addsinglechoice(singlechoice);
    }

    @Override
    public List<Singlechoice> allsinglechoice(String subject) {
        return singlechoiceMapper.allsinglechoice(subject);
    }

    @Override
    public int countsinglechoice(String subject) {
        return singlechoiceMapper.countsinglechoice(subject);
    }
}
