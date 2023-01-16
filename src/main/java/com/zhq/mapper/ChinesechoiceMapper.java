package com.zhq.mapper;

import com.zhq.pojo.Chinesechoice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChinesechoiceMapper {
    int addchinesechoice(Chinesechoice chinesechoice);
    List<Chinesechoice> allchinesechoice(String type);
}
