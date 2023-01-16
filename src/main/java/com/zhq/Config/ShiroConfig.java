package com.zhq.Config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("manager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiro = new ShiroFilterFactoryBean();
        shiro.setSecurityManager(securityManager);

        HashMap<String, String> map = new LinkedHashMap<>();
        /*
            anon：无需认证就可以访问
            authc：必须认证了才能访问
            user： 必须拥有记住我才可以用
            perms： 拥有对某个资源的权限才能访问
            role： 拥有某个权限才能访问
        */
        map.put("tologin","anon");
        map.put("index","authc");
        map.put("/index/*","perms[user:all]");
        shiro.setFilterChainDefinitionMap(map);
        shiro.setLoginUrl("/tologin");
        return shiro;
    }

    @Bean(name = "manager")
    public DefaultWebSecurityManager securityManager(@Qualifier("realm") Realm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    @Bean
    public Realm realm(){
        return new Realm();
    }

}
