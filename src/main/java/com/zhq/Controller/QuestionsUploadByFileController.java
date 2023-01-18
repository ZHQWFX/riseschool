package com.zhq.Controller;

import com.zhq.Service.QuestionService;
import com.zhq.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author chenchenchen
 * @create 2023-01-18 14:28
 */
@RequestMapping("/question")
@RestController
public class QuestionsUploadByFileController {

    @Resource
    private QuestionService questionService;

    /**
     *
     * @param multipartFile 后缀为doc或docx的文件
     * @return
     * @Description 上传文件生成题库
     */
    @PostMapping("/upload")
    public Result questionUploadByFile(MultipartFile multipartFile){
        questionService.insertBatchQuestion(multipartFile);
        return Result.ok(null);
    }
}
