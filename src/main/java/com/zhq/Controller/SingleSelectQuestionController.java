package com.zhq.Controller;

import com.zhq.Service.SingleSelectQuestionService;
import com.zhq.pojo.Result;
import com.zhq.pojo.SingleSelectQuestion;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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


    @PostMapping("/upload")
    public Result addSingleSelectQuestionByFile(MultipartFile multipartFile){
        singleSelectQuestionService.insertBatchQuestion(multipartFile);
        return Result.ok(null);
    }

    @PostMapping("/addSingleSelectQuestion")
    public Result addSingleSelectQuestion(@RequestBody List<SingleSelectQuestion> singleSelectQuestions){
        singleSelectQuestionService.insertBatchQuestion(singleSelectQuestions);
        return Result.ok(null);
    }

    @GetMapping("/list/{pageNum}/{pageSize}")
    public Result getSingleSelectQuestionList(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
        Map<String, Object> map =
                singleSelectQuestionService.findSingleSelectQuestionList(pageNum, pageSize);
        return Result.ok(map);
    }

    @GetMapping("/getSingleSelectQuestionByQuestionId/{questionId}")
    public Result getSingleSelectQuestionByQuestionId(@PathVariable Integer questionId){
        SingleSelectQuestion singleSelectQuestion = singleSelectQuestionService.findQuestionByQuestionId(questionId);
        return Result.ok(singleSelectQuestion);
    }

    @PutMapping("/updateSingleSelectQuestion")
    public Result updateSingleSelectQuestion(SingleSelectQuestion singleSelectQuestion){
        singleSelectQuestionService.updateByQuestion(singleSelectQuestion);
        return Result.ok(null);
    }

    @DeleteMapping("/removeSingleSelectQuestion/{questionId}")
    public Result removeSingleSelectQuestion(Integer questionId){
        singleSelectQuestionService.deleteQuestionByQuestionId(questionId);
        return Result.ok(null);
    }

}
