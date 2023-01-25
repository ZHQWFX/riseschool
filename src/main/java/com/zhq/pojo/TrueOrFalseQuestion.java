package com.zhq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenchenchen
 * @create 2023-01-17 15:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrueOrFalseQuestion {
    private Integer questionId;
    private String question;
    private String answer;
    private String subjectName;
    private String chapter;
    private String accountUser;
    private String analysis;
}
