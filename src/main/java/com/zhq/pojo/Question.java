package com.zhq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author chenchenchen
 * @create 2023-01-18 13:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private List<SingleSelectQuestion> singleSelectQuestions;
    private List<MultiSelectQuestion> multiSelectQuestions;
    private List<TrueOrFalseQuestion> trueOrFalseQuestions;
}
