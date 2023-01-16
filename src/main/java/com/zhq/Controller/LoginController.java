package com.zhq.Controller;

import com.zhq.pojo.Loginuser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/login")
    public String login(Loginuser user, Model model){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);
            return "index";
        } catch (UnknownAccountException uae) {
            model.addAttribute("msg","用户名不存在");
        } catch (IncorrectCredentialsException ice) {
            model.addAttribute("msg","密码错误");
        }
        return "login";
    }
    @RequestMapping("/index/adduser")
    public String adduser(){

        return "index/adduser";
    }
    @RequestMapping("/index/updateuser")
    public String updateuser(){

        return "index/updateuser";
    }
}
