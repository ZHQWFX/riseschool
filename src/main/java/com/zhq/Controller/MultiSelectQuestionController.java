package com.zhq.Controller;

import com.zhq.Service.MultiSelectQuestionService;
import com.zhq.pojo.MultiSelectQuestion;
import com.zhq.pojo.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author chenchenchen
 * @create 2023-01-18 15:43
 */
@RequestMapping("/MultiSelectQuestion")
@RestController
public class MultiSelectQuestionController {

    @Resource
    private MultiSelectQuestionService multiSelectQuestionService;

    /**
     *
     * @param pageNum 第几页
     * @param pageSize 页面记录数
     * @return
     * @Description 分页查询多选题
     */
    @GetMapping("/pageList/{pageNum}/{pageSize}")
    public Result getMultiSelectQuestionPageList(@PathVariable Integer pageNum,
                                                 @PathVariable Integer pageSize){
        Map<String, Object> map = multiSelectQuestionService.findAllMultiSelectQuestion(pageNum, pageSize);
        return Result.ok(map);
    }

    /**
     *
     * @param multiSelectQuestion
     * @return
     * @Description 新增一题
     */
    @PostMapping("/addQuestion")
    public Result addQuestion(@RequestBody MultiSelectQuestion multiSelectQuestion){
        multiSelectQuestionService.insertOneQuestion(multiSelectQuestion);
        return Result.ok(null);
    }

    /**
     *
     * @param questionId
     * @return
     * @Description 根据questionId查询题目，为修改做准备
     */
    @GetMapping("/getMultiSelectQuestion/{questionId}")
    public Result getMultiSelectQuestion(@PathVariable Integer questionId){
        MultiSelectQuestion question = multiSelectQuestionService.findMultiSelectQuestionByQuestionId(questionId);
        return Result.ok(question);
    }

    /**
     *
     * @param multiSelectQuestion
     * @return
     * @Description 修改题目
     */
    @PutMapping("/updateMultiSelectQuestion")
    public Result updateMultiSelectQuestion(@RequestBody MultiSelectQuestion multiSelectQuestion){
        multiSelectQuestionService.updateMultiSelectQuestion(multiSelectQuestion);
        return Result.ok(null);
    }

    /**
     *
     * @param questionId
     * @return
     * @Description 根据questionId删除题目
     */
    @DeleteMapping("/deleteMultiSelectQuestion/{questionId}")
    public Result deleteMultiSelectQuestion(@PathVariable Integer questionId){
        multiSelectQuestionService.deleteMultiSelectQuestion(questionId);
        return Result.ok(null);
    }



}
