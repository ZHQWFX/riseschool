package com.zhq.mapper;

import com.zhq.pojo.Chapter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenchenchen
 * @create 2023-01-26 20:57
 */
@Mapper
public interface ChapterMapper {
    /**
     *
     * @param subjectId
     * @Description 根据subjectId获取章节
     */
    List<Chapter> findChapterBySubjectId(@Param("subjectId")Integer subjectId);

    /**
     *
     * @param chapter
     * @return
     * @Description 新增科目
     */
    int insertChapter(@Param("chapter")Chapter chapter);

    /**
     *
     * @param chapterId
     * @return
     * @Description 修改章节名
     */
    int updateChapterTitleByChapterId(@Param("chapterId")Integer chapterId,@Param("chapterTitle")String chapterTitle);

    /**
     *
     * @param chapterId
     * @return
     * @Description 根据章节id删除章节
     */
    int removeChapterByChapterId(@Param("chapterId")Integer chapterId);

    /**
     *
     * @param subjectId
     * @return
     * @Description 根据科目id删除章节
     */
    int removeChapterBySubjectId(@Param("subjectId")Integer subjectId);
}
