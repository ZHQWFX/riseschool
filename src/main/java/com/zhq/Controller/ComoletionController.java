package com.zhq.Controller;

import com.zhq.Service.CompletionService;
import com.zhq.pojo.Completion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class ComoletionController {
    @Autowired
    CompletionService completionService;
    @RequestMapping("/allcompletion/{subject}")
    public List<Completion> allcompletion(@PathVariable String subject){
        return  completionService.allcompletion(subject);
    }

    @RequestMapping("/countcompletion")
    public int countcompletion(){
        return completionService.countcompletion();
    }
}
