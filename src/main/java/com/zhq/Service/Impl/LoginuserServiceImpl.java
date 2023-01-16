package com.zhq.Service.Impl;

import com.zhq.Service.LoginuserService;
import com.zhq.mapper.LoginuserMapper;
import com.zhq.pojo.Loginuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginuserServiceImpl implements LoginuserService {

    @Autowired
    LoginuserMapper loginuserMapper;

    @Override
    public Loginuser queryLoginuser(String username) {
        return loginuserMapper.queryLoginuser(username);
    }
}
