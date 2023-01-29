package com.zhq.Controller;

import com.zhq.Service.SinglechoicewrongService;
import com.zhq.pojo.Result;
import com.zhq.pojo.Singlechoicewrong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SinglechoicewrongController {
    @Autowired
    SinglechoicewrongService singlechoicewrongService;

    /**
     *
     * @param singlechoicewrong
     * @return
     * @Description 将做错的题目添加进错题库
     */
    @PostMapping("/addsinglechoicewrong")
    public int addchinesechoicewrong(@RequestBody Singlechoicewrong singlechoicewrong){
        System.out.println(singlechoicewrong);
        return singlechoicewrongService.addsinglechoicewrong(singlechoicewrong);
    }

    /**
     *
     * @param question
     * @return
     * @Desctiption 查询错题库中是否有当前做错的题目  如果存在则不添加
     */
    @RequestMapping("/findsinglechoicewrong")
    public int findChinesechoicewrong(String question,String subject){
        return singlechoicewrongService.findsinglechoicewrong(question,subject);
    }
    /**
     *
     * @param id
     * @Descriprion 在错题库中答对的题目将其删除
     */
    @DeleteMapping("/deletesinglechoicewrong/{id}")
    public Result deletesinglechoicewrong(@PathVariable Integer id){
        singlechoicewrongService.deletesinglechoicewrong(id);
        return Result.ok(null);
    }

    /**
     *
     * @return List<Singlechoicewrong>
     * @Description 查找错题库中的所有错题
     */
    @RequestMapping("/allsinglechoicewrong")
    List<Singlechoicewrong> allsinglechoicewrong(String subject,String account_user_name){
        return singlechoicewrongService.allsinglechoicewrong(subject,account_user_name);
    }

}
