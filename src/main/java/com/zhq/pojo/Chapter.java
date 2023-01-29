package com.zhq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author chenchenchen
 * @create 2023-01-27 18:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Chapter {
    private Integer chapterId;
    private String chapterTitle;
    private Integer subjectId;
}
