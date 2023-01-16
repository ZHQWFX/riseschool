package com.zhq.mapper;

import com.zhq.pojo.Loginuser;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface LoginuserMapper {
    Loginuser queryLoginuser(String username);
}
