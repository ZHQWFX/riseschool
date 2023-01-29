package com.zhq.Service;

import com.zhq.pojo.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenchenchen
 * @create 2023-01-26 20:39
 */
public interface SubjectService {
    /**
     *
     * @param accountUser
     * @Description 根据accountUser获取subject
     */
    List<Subject> findSubjectByAccountUser(String accountUser);

    /**
     *
     * @param subject
     * @return
     * @Description 添加科目
     */
    boolean insertSubject(Subject subject);

    /**
     *
     * @param subjectId
     * @return
     * @Description 根据subjectId删除科目
     */
    boolean removeSubjectBySubjectId(Integer subjectId);

    /**
     *
     * @param subjectId
     * @param subjectName
     * @return
     * @Description 修改科目名
     */
    boolean updateSubjectName(Integer subjectId,String subjectName);


}
