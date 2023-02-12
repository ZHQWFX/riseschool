package com.zhq.Controller;

import com.zhq.Service.SinglechoiceService;
import com.zhq.pojo.Singlechoice;
import com.zhq.pojo.Trueorfalsewrong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Controller
public class SinglechoiceController {
    @Autowired
    SinglechoiceService singlechoiceService;

    @RequestMapping("/singlechoice")
    public String chinesechoice(){
        return "chinese/chinesechoice";
    }

    /**
     *
     * @param subject
     * @return List<Singlechoice>
     * @Description 根据科目查询所有单选题
     */
    @RequestMapping("/allsinglechoice/{subject}")
    @ResponseBody
    public List<Singlechoice> allsinglechoice(@PathVariable String subject){
        List list = new ArrayList(singlechoiceService.allsinglechoice(subject));
        Random random = new Random();
        Collections.shuffle(list,random);
        return list;
    }

    /**
     *
     * @param singlechoice
     * @return
     * @Descriprion 添加单选题
     */
    @RequestMapping("/addchinesechoice")
    public String addchinesechoice(Singlechoice singlechoice, Model model){
        System.out.println(singlechoice);
        int i = singlechoiceService.addsinglechoice(singlechoice);
        if (i>0){
            model.addAttribute("msg","添加成功");

        }else {
            model.addAttribute("msg","添加失败");
        }
        return "chinese/chinesechoice";
    }

    /**
     *
     * @param subject
     * @return
     * @Description 根据科目查询出该科目题目总数
     */
    @RequestMapping("/countsinglechoice/{subject}")
    @ResponseBody
   public Integer countsinglechoice(@PathVariable String subject){
        return singlechoiceService.countsinglechoice(subject);
    }
}
