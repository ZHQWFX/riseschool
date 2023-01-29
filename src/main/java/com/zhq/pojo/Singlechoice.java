package com.zhq.pojo;

import lombok.Data;

@Data
public class Singlechoice {
    private int id;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answer;
    private String subject;
    private String analysis;
}
