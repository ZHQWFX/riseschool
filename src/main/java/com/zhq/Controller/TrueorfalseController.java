package com.zhq.Controller;

import com.zhq.Service.TrueorfalseService;
import com.zhq.pojo.Trueorfalse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrueorfalseController {
    @Autowired
    TrueorfalseService trueorfalseService;

    @RequestMapping("/alltrueorfalse/{subject}")
    public List<Trueorfalse> alltrueorfalse(@PathVariable String subject){
        return trueorfalseService.alltrueorfalse(subject);
    }
}
