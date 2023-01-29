package com.zhq.mapper;

import com.zhq.pojo.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenchenchen
 * @create 2023-01-26 20:57
 */
@Mapper
public interface SubjectMapper {
    /**
     *
     * @param accountUser
     * @Description 根据accountUser获取subject
     */
    List<Subject> findSubjectByAccountUser(@Param("accountUser") String accountUser);

    /**
     *
     * @param subject
     * @return
     * @Description 添加科目
     */
    int insertSubject(@Param("subject")Subject subject);

    /**
     *
     * @param subjectId
     * @return
     * @Description 根据subjectId删除科目
     */
    int removeSubjectBySubjectId(@Param("subjectId")Integer subjectId);

    /**
     *
     * @param subjectId
     * @param subjectName
     * @return
     * @Description 修改科目名
     */
    int updateSubjectName(@Param("subjectId")Integer subjectId,@Param("subjectName")String subjectName);
}
