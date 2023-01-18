package com.zhq.Controller;

import com.zhq.Service.TrueOrFalseQuestionService;
import com.zhq.pojo.Result;
import com.zhq.pojo.TrueOrFalseQuestion;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author chenchenchen
 * @create 2023-01-18 15:43
 */
@RequestMapping("/TrueOrFalseQuestion")
@RestController
public class TrueOrFalseQuestionController {

    @Resource
    private TrueOrFalseQuestionService trueOrFalseQuestionService;

    /**
     *
     * @param pageNum 第几页
     * @param pageSize 页面记录数
     * @return
     * @Description 分页查询判断题
     */
    @GetMapping("/PageList/{pageNum}/{pageSize}")
    public Result getTrueOrFalseQuestionPageList(@PathVariable Integer pageNum,
                                                 @PathVariable Integer pageSize){
        Map<String, Object> map = trueOrFalseQuestionService.findAllTrueOrFalseQuestion(pageNum, pageSize);
        return Result.ok(map);
    }

    /**
     *
     * @param trueOrFalseQuestion
     * @return
     * @Description 新增一题
     */
    @PostMapping("/addTrueOrFalseQuestion")
    public Result addTrueOrFalseQuestion(@RequestBody TrueOrFalseQuestion trueOrFalseQuestion){
        trueOrFalseQuestionService.insertOneQuestion(trueOrFalseQuestion);
        return Result.ok(null);
    }

    /**
     *
     * @param questionId
     * @return
     * @Description 根据questionId查询题目，为修改题目做准备
     */
    @GetMapping("findOneTrueOrFalseQuestion/{questionId}")
    public Result findOneTrueOrFalseQuestion(@PathVariable Integer questionId){
        TrueOrFalseQuestion trueOrFalseQuestion = trueOrFalseQuestionService.findTrueOrFalseQuestionId(questionId);
        if(trueOrFalseQuestion!=null){
            return Result.ok(trueOrFalseQuestion).message("查询成功!");
        }
        return Result.fail().message("查询失败!");
    }

    /**
     *
     * @param trueOrFalseQuestion
     * @return
     * @Description 修改题目
     */
    @PutMapping("updateTrueOrFalseQuestion")
    public Result updateTrueOrFalseQuestion(@RequestBody TrueOrFalseQuestion trueOrFalseQuestion){
        trueOrFalseQuestionService.updateTrueOrFalseQuestion(trueOrFalseQuestion);
        return Result.ok(null);
    }

    /**
     *
     * @param questionId
     * @return
     * @Description 根据questionId删除题目
     */
    @DeleteMapping("removeQuestion/{questionId}")
    public Result removeQuestionByQuestionId(@PathVariable Integer questionId){
        trueOrFalseQuestionService.deleteTrueOrFalseQuestion(questionId);
        return Result.ok(null);
    }
}
