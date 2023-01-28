package com.zhq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenchenchen
 * @create 2023-01-16 16:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SingleSelectQuestion {
    private Integer questionId;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answer;
    private String analysis;
    private Integer subjectId;
    private Integer chapterId;



}
