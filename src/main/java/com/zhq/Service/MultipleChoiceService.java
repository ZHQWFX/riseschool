package com.zhq.Service;

import com.zhq.pojo.MultipleChoice;

import java.util.List;
import java.util.Map;

/**
 * @author ZHQ
 * @create 2023/1/29 16:40
 */
public interface MultipleChoiceService {
    /**
     *
     * @return List<MultipleChoice>
     * @Description 查找出所有的多选题
     */
    List<MultipleChoice> allmultiplechoice(String subject);

    /**
     *
     * @return List<MultipleChoice>
     * @Description 分页查找出所有的多选题
     */
    Map<String,Object> pageallmultiplechoice(Integer pageNum,Integer pageSize);

}
