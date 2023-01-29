package com.zhq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trueorfalsewrong {
    private int id;
    private String question;
    private int answer;
    private String subject;
    private String chapter;
    private String analysis;
    private String account_user_name;
    private String label;
}
