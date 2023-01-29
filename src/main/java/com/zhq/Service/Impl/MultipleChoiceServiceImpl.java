package com.zhq.Service.Impl;

import com.zhq.Service.MultipleChoiceService;
import com.zhq.mapper.MultipleChoiceMapper;
import com.zhq.pojo.MultipleChoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZHQ
 * @create 2023/1/29 16:41
 */
@Service
public class MultipleChoiceServiceImpl implements MultipleChoiceService {
    @Autowired
    MultipleChoiceMapper multipleChoiceMapper;

    @Override
    public List<MultipleChoice> allmultiplechoice() {
        return multipleChoiceMapper.allmultiplechoice();
    }
}
