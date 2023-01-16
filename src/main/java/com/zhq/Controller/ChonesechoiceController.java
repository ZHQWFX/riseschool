package com.zhq.Controller;

import com.zhq.Service.ChinesechoiceService;
import com.zhq.pojo.Chinesechoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ChonesechoiceController {
    @Autowired
    ChinesechoiceService chinesechoiceService;
    @RequestMapping("/chinesechoice")
    public String chinesechoice(){
        return "chinese/chinesechoice";
    }

    @RequestMapping("/allchinesechoice")
    @ResponseBody
    public List<Chinesechoice> allchinesechoice(String type){
        return chinesechoiceService.allchinesechoice(type);
    }

    @RequestMapping("/addchinesechoice")
    public String addchinesechoice(Chinesechoice chinesechoice, Model model){
        System.out.println(chinesechoice);
        int i = chinesechoiceService.addchinesechoice(chinesechoice);
        if (i>0){
            model.addAttribute("msg","添加成功");

        }else {
            model.addAttribute("msg","添加失败");
        }
        return "chinese/chinesechoice";
    }
}
