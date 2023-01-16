package com.zhq.mapper;

import com.zhq.pojo.Chinesechoicewrong;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChinesechoicewrongMapper {
    int addChinesechoicewrong(Chinesechoicewrong chinesechoicewrong);
    int findChinesechoicewrong(String question);
}
