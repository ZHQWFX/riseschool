package com.zhq.Controller;

import com.zhq.Service.TrueorfalsewrongService;
import com.zhq.pojo.Result;
import com.zhq.pojo.Trueorfalsewrong;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ZHQ
 * @create 2023-1-25 21:15
 */
@RestController
@RequestMapping("/trueorfalsewrong")
public class TrueorfalsewrongController {
    @Autowired
    private TrueorfalsewrongService trueorfalsewrongService;
    /**
     *
     * @param trueorfalsewrong
     * @return
     * @Description 将判断题答错的题目写入错题库
     */
    @PostMapping("/inserttrueorfalsewrong")
    public Result inserttrueorfalsewrong(@RequestBody Trueorfalsewrong trueorfalsewrong){
        trueorfalsewrongService.inserttrueorfalsewrong(trueorfalsewrong);
        return Result.ok(null);
    }

    /**
     *
     * @param question
     * @Description 本题答错后，查询错题库内是否存在
     */
    @RequestMapping("/querytrueorfalsewrong/{question}")
    public int querytrueorfalsewrong(@PathVariable String question){
        return trueorfalsewrongService.querytrueorfalsewrong(question);

    }

    /**
     *
     * @return List<Trueorfalsewrong>
     * @Description 查询错题库中的所有题目
     */
    @RequestMapping("/alltrueorfalse")
    public List<Trueorfalsewrong> alltrueorfalsewrong(String subject,String account_user_name){
        return trueorfalsewrongService.alltrueorfalsewrong(subject,account_user_name);
    }

    /**
     *
     * @param id
     * @return
     * @Description 错题答对后根据id将其删除
     */
    @DeleteMapping("/deletetrueorfalsewrong/{id}")
    public Result deletetrueorfalse(@PathVariable Integer id){
        System.out.println(id);
        trueorfalsewrongService.deletetrueorfalsewrong(id);
        return Result.ok(id);
    }
}
