package com.zhq.Service;

import com.zhq.pojo.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenchenchen
 * @create 2023-01-26 20:42
 */
public interface ChapterService {
    /**
     *
     * @param subjectId
     * @Description 根据subjectId获取章节
     */
    List<Chapter> findChapterBySubjectId(Integer subjectId);

    /**
     *
     * @param chapter
     * @return
     * @Description 新增科目
     */
    boolean insertChapter(Chapter chapter);

    /**
     *
     * @param chapterId
     * @return
     * @Description 修改章节名
     */
    boolean updateChapterTitleByChapterId(Integer chapterId,String chapterTitle);

    /**
     *
     * @param chapterId
     * @return
     * @Description 根据章节id删除章节
     */
    boolean removeChapterByChapter(Integer chapterId);


    /**
     *
     * @param subjectId
     * @return
     * @Description 根据科目id删除章节
     */
    boolean removeChapterBySubjectId(Integer subjectId);
}
