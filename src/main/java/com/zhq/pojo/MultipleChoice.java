package com.zhq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author ZHQ
 * @create 2023/1/29 16:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultipleChoice {
    private int multiChoiceId;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answer;
    private String subject;
    private String analysis;
}
