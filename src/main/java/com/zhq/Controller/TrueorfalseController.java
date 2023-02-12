package com.zhq.Controller;

import com.zhq.Service.TrueorfalseService;
import com.zhq.pojo.Trueorfalse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@RestController
public class TrueorfalseController {
    @Autowired
    TrueorfalseService trueorfalseService;

    @RequestMapping("/alltrueorfalse/{subject}")
    public List alltrueorfalse(@PathVariable String subject){
        List list = new ArrayList(trueorfalseService.alltrueorfalse(subject));
        Random random = new Random();
        Collections.shuffle(list,random);
        return list;
    }
}
