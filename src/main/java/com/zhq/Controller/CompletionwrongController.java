package com.zhq.Controller;

import com.zhq.Service.CompletionwrongService;
import com.zhq.pojo.Completionwrong;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompletionwrongController {
    @Autowired
    CompletionwrongService completionwrongService;
    @PostMapping("/addcompletionwrong")
    public int addcompletionwrong(@RequestBody Completionwrong completionwrong){
        return completionwrongService.addcompletionwrong(completionwrong);
    }
    @RequestMapping("/findcompletionwrongquestion/{question}")
    public int findcompletionwrongquestion(@PathVariable String question){
        return completionwrongService.findcompletionwrongquestion(question);
    }
    @RequestMapping("/allcompletionwrong")
    public List<Completionwrong> allcompletion(String subject,String account_user_name){
        return completionwrongService.allcompletionwrong(subject,account_user_name);
    }

    @DeleteMapping("/deletecompletionwrong/{id}")
    public int deletecompletionwrong(@PathVariable int id){
        return completionwrongService.deletecompletionwrong(id);
    }
}
