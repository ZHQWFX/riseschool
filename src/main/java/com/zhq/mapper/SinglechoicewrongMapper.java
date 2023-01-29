package com.zhq.mapper;

import com.zhq.pojo.Singlechoicewrong;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ZHQ
 * @create 2023-1-17 18:23
 */
@Mapper
public interface SinglechoicewrongMapper {
    /**
     *
     * @param singlechoicewrong
     * @return
     * @Description 将做错的题目添加进错题库
     */
    int addsinglechoicewrong(Singlechoicewrong singlechoicewrong);

    /**
     *
     * @param question
     * @return
     * @Desctiption 查询错题库中是否有当前做错的题目  如果存在则不添加
     */
    int findsinglechoicewrong(String question,String subject);

    /**
     *
     * @param id
     * @Descriprion 在错题库中答对的题目将其删除
     */
    void deletesinglechoicewrong(int id);

    /**
     * @param subject
     * @return List<Singlechoicewrong>
     * @Description 查找错题库中的所有错题
     */
    List<Singlechoicewrong> allsinglechoicewrong(String subject,String account_user_name);
}
