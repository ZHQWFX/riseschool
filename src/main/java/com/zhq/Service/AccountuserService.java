package com.zhq.Service;

import com.zhq.pojo.Accountuser;

public interface AccountuserService {
    int selectaccountuser(String account_user_name);
    int registeraccountuser(Accountuser accountuser);
}
