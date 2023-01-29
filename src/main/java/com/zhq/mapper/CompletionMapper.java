package com.zhq.mapper;

import com.zhq.pojo.Completion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompletionMapper {
    List<Completion> allcompletion(String subject);
    int countcompletion();
}
