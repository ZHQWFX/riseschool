package com.zhq.mapper;


import com.zhq.pojo.Singlechoice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ZHQ
 * @create 2023-1-27 18:01
 */
@Mapper
public interface SinglechoiceMapper {
    /**
     *
     * @param singlechoice
     * @return
     * @Descriprion 添加单选题
     */
    int addsinglechoice(Singlechoice singlechoice);

    /**
     *
     * @param subject
     * @return List<Singlechoice>
     * @Description 根据科目查询所有单选题
     */
    List<Singlechoice> allsinglechoice(String subject);

    /**
     *
     * @param subject
     * @return
     * @Description 根据科目查询出该科目题目总数
     */
    int countsinglechoice(String subject);
}
