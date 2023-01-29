package com.zhq.Service;

import com.zhq.pojo.Trueorfalsewrong;

import java.util.List;

public interface TrueorfalsewrongService {
    /**
     *
     * @param trueorfalsewrong
     * @Description 将判断题答错的题目写入错题库
     */
    void inserttrueorfalsewrong(Trueorfalsewrong trueorfalsewrong);

    /**
     *
     * @param question
     * @Description 本题答错后，查询错题库内是否存在
     */
    int querytrueorfalsewrong(String question);

    /**
     * @return List<Trueorfalsewrong>
     * @Description 查询错题库中的所有题目
     */
    List<Trueorfalsewrong> alltrueorfalsewrong(String subject,String account_user_name);
    /**
     * @param id
     * @return
     * @Description 错题库中的问题答对后根据id将其删除
     */
    int deletetrueorfalsewrong(Integer id);
}
