package com.zhq.Config;

import com.zhq.Service.LoginuserService;
import com.zhq.pojo.Loginuser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class Realm extends AuthorizingRealm {
    @Autowired
    LoginuserService loginuserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("进入授权");
        Subject subject = SecurityUtils.getSubject();
        Loginuser user = (Loginuser) subject.getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        System.out.println(user.getPerm());
        info.addStringPermission(user.getPerm());
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("进入认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Loginuser user = loginuserService.queryLoginuser(token.getUsername());
        if (user == null){
            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
