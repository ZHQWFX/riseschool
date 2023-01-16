package com.zhq.mapper;

import com.zhq.pojo.Accountuser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountuserMapper {
    int selectaccountuser(String account_user_name);
    int registeraccountuser(Accountuser accountuser);
}
