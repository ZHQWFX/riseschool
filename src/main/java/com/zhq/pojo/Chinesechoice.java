package com.zhq.pojo;

import lombok.Data;

@Data
public class Chinesechoice {
    private int id;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answer;
    private String type;
    private String analysis;
}
