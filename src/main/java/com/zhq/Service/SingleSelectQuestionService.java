package com.zhq.Service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author chenchenchen
 * @create 2023-01-16 16:54
 */
public interface SingleSelectQuestionService {
    /**
     *
     * @param multipartFile
     * @Description 批量添加题目
     */
    void insertBatchQuestion(MultipartFile multipartFile);
}
