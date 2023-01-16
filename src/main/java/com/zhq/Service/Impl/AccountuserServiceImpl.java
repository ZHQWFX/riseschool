package com.zhq.Service.Impl;

import com.zhq.Service.AccountuserService;
import com.zhq.mapper.AccountuserMapper;
import com.zhq.pojo.Accountuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountuserServiceImpl implements AccountuserService {
    @Autowired
    AccountuserMapper accountuserMapper;

    @Override
    public int selectaccountuser(String account_user_name) {
        return accountuserMapper.selectaccountuser(account_user_name);
    }

    @Override
    public int registeraccountuser(Accountuser accountuser) {
        return accountuserMapper.registeraccountuser(accountuser);
    }
}
