package com.zhq.Controller;

import com.zhq.Service.SingleSelectQuestionService;
import com.zhq.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author chenchenchen
 * @create 2023-01-16 18:42
 */
@RestController
public class SingleSelectQuestionController {

    @Resource
    private SingleSelectQuestionService singleSelectQuestionService;


    @PostMapping("/upload")
    public Result addSingleSelectQuestion(MultipartFile multipartFile){
        singleSelectQuestionService.insertBatchQuestion(multipartFile);
        return null;
    }
}
