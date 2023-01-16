package com.zhq.pojo;

import lombok.Data;

@Data
public class Chinesechoicewrong {
    private int id;
    private String account_user_name;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answer;
    private String analysis;
}
