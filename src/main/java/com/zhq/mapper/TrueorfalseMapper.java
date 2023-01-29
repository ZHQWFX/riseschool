package com.zhq.mapper;

import com.zhq.pojo.Trueorfalse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TrueorfalseMapper {
    List<Trueorfalse> alltrueorfalse(String subject);

}
