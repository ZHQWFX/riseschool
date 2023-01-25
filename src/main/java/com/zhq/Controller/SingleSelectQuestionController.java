package com.zhq.Controller;

import com.zhq.Service.SingleSelectQuestionService;
import com.zhq.pojo.Result;
import com.zhq.pojo.SingleSelectQuestion;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author chenchenchen
 * @create 2023-01-16 18:42
 */
@RequestMapping("/SingleSelectQuestion")
@RestController
public class SingleSelectQuestionController {

    @Resource
    private SingleSelectQuestionService singleSelectQuestionService;

    /**
     *
     * @param singleSelectQuestions
     * @return
     * @Description 批量插入单选题
     */
    @PostMapping("/addBatchSingleSelectQuestion")
    public Result addBatchSingleSelectQuestion(@RequestBody List<SingleSelectQuestion> singleSelectQuestions){
        singleSelectQuestionService.insertBatchQuestion(singleSelectQuestions);
        return Result.ok(null);
    }

    @PostMapping("/addSingleSelectQuestion")
    public Result addSingleSelectQuestion(@RequestBody SingleSelectQuestion singleSelectQuestion){
        singleSelectQuestionService.insertOneQuestion(singleSelectQuestion);
        return Result.ok(null);
    }
    /**
     *
     * @param pageNum 第几页
     * @param pageSize 页面记录数
     * @return
     * @Description 分页查询数据
     */
    @GetMapping("/list/{pageNum}/{pageSize}")
    public Result getSingleSelectQuestionList(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
        Map<String, Object> map =
                singleSelectQuestionService.findSingleSelectQuestionList(pageNum, pageSize);
        return Result.ok(map);
    }

    /**
     *
     * @param questionId
     * @return
     * @Description 根据questionId查询题目，为修改题目做准备
     */
    @GetMapping("/getSingleSelectQuestionByQuestionId/{questionId}")
    public Result getSingleSelectQuestionByQuestionId(@PathVariable Integer questionId){
        SingleSelectQuestion singleSelectQuestion = singleSelectQuestionService.findQuestionByQuestionId(questionId);
        return Result.ok(singleSelectQuestion);
    }

    /**
     *
     * @param singleSelectQuestion
     * @return
     * @Description 修改题目
     */
    @PutMapping("/updateSingleSelectQuestion")
    public Result updateSingleSelectQuestion(SingleSelectQuestion singleSelectQuestion){
        singleSelectQuestionService.updateByQuestion(singleSelectQuestion);
        return Result.ok(null);
    }

    /**
     *
     * @param questionId
     * @return
     * @Description 根据questionId删除题目
     */
    @DeleteMapping("/removeSingleSelectQuestion/{questionId}")
    public Result removeSingleSelectQuestion(@PathVariable Integer questionId){
        singleSelectQuestionService.deleteQuestionByQuestionId(questionId);
        return Result.ok(null);
    }

}
