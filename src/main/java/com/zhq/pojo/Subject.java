package com.zhq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author chenchenchen
 * @create 2023-01-27 18:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Subject {
    private int subjectId;
    private String subjectName;
    private String accountUser;
}
