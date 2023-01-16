package com.zhq.Controller;

import com.zhq.Service.ChinesechoicewrongService;
import com.zhq.pojo.Chinesechoicewrong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChinesechoicewrongController {
    @Autowired
    ChinesechoicewrongService chinesechoicewrongService;
    @RequestMapping("/addchinesechoicewrong")
    public int addchinesechoicewrong(Chinesechoicewrong chinesechoicewrong){
        return chinesechoicewrongService.addChinesechoicewrong(chinesechoicewrong);
    }

    @RequestMapping("/findChinesechoicewrong")
    public int findChinesechoicewrong(String question){
        return chinesechoicewrongService.findChinesechoicewrong(question);
    }
}
