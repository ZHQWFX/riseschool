package com.zhq.Service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author chenchenchen
 * @create 2023-01-18 13:28
 */
public interface QuestionService {
    void insertBatchQuestion(MultipartFile multipartFile);
}
