package com.zhq.Controller;

import com.zhq.Service.AccountuserService;
import com.zhq.pojo.Accountuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountuserController {
    @Autowired
    AccountuserService accountuserService;

    @PostMapping("/registeraccountuser")
    public int registeraccountuser(@RequestBody Accountuser accountuser){
        return accountuserService.registeraccountuser(accountuser);
    }

    @RequestMapping("/selectaccountuser/{account_user_name}")
    public int selectaccountuser(@PathVariable String account_user_name){
        return accountuserService.selectaccountuser(account_user_name);
    }
}
