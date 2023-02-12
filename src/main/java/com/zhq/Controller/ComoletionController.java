package com.zhq.Controller;

import com.zhq.Service.CompletionService;
import com.zhq.pojo.Completion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Controller
@ResponseBody
public class ComoletionController {
    @Autowired
    CompletionService completionService;
    @RequestMapping("/allcompletion/{subject}")
    public List<Completion> allcompletion(@PathVariable String subject){
        List<Completion> list = new ArrayList(completionService.allcompletion(subject));
        list.stream().forEach(
                item->{
                    String[] strList = item.getAnswer().split(",|，");
                    item.setAnswers(strList);
                }
        );
        Random random = new Random();
        Collections.shuffle(list,random);
        return  list;
    }

    @RequestMapping("/countcompletion")
    public int countcompletion(){
        return completionService.countcompletion();
    }
}
