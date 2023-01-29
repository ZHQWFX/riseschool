package com.zhq.mapper;

import com.zhq.pojo.MultipleChoice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ZHQ
 * @create 2023/1/29 16:25
 */
@Mapper
public interface MultipleChoiceMapper {
    /**
     *
     * @return List<MultipleChoice>
     * @Description 查找出所有的多选题
     */
    List<MultipleChoice> allmultiplechoice();


}
