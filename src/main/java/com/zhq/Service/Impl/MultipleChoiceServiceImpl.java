package com.zhq.Service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhq.Service.MultipleChoiceService;
import com.zhq.mapper.MultipleChoiceMapper;
import com.zhq.pojo.MultipleChoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZHQ
 * @create 2023/1/29 16:41
 */
@Service
public class MultipleChoiceServiceImpl implements MultipleChoiceService {
    @Autowired
    MultipleChoiceMapper multipleChoiceMapper;

    @Override
    public List<MultipleChoice> allmultiplechoice(String subject) {
        return multipleChoiceMapper.allmultiplechoice(subject);
    }

    @Override
    public Map<String, Object> pageallmultiplechoice(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<MultipleChoice> multipleChoices = multipleChoiceMapper.allmultiplechoice("语文");
        PageInfo<MultipleChoice> pageInfo = new PageInfo<>(multipleChoices);
        Map<String,Object> map = new HashMap<>();
        map.put("currentPage",pageInfo.getPageNum());
        map.put("totalPage",pageInfo.getPages());
        map.put("totalCount",pageInfo.getTotal());
        map.put("record",multipleChoices);
        return map;
    }
}
