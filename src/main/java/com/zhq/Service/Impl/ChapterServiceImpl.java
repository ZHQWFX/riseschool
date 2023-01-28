package com.zhq.Service.Impl;

import com.zhq.Service.ChapterService;
import com.zhq.Service.MultiSelectQuestionService;
import com.zhq.Service.SingleSelectQuestionService;
import com.zhq.Service.TrueOrFalseQuestionService;
import com.zhq.mapper.ChapterMapper;
import com.zhq.pojo.Chapter;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenchenchen
 * @create 2023-01-27 19:11
 */
public class ChapterServiceImpl implements ChapterService {

    @Resource
    private ChapterMapper chapterMapper;

    @Resource
    private SingleSelectQuestionService singleSelectQuestionService;

    @Resource
    private MultiSelectQuestionService multiSelectQuestionService;

    @Resource
    private TrueOrFalseQuestionService trueOrFalseQuestionService;

    @Override
    public List<Chapter> findChapterBySubjectId(Integer subjectId) {
        return chapterMapper.findChapterBySubjectId(subjectId);
    }

    @Override
    public boolean insertChapter(Chapter chapter) {
        return chapterMapper.insertChapter(chapter)>0;
    }

    @Override
    public boolean updateChapterTitleByChapterId(Integer chapterId, String chapterTitle) {
        return chapterMapper.updateChapterTitleByChapterId(chapterId, chapterTitle)>0;
    }

    @Transactional
    @Override
    public boolean removeChapterByChapter(Integer chapterId) {
        singleSelectQuestionService.deleteQuestionByChapterId(chapterId);
        multiSelectQuestionService.deleteQuestionByChapterId(chapterId);
        trueOrFalseQuestionService.deleteQuestionByChapterId(chapterId);
        return chapterMapper.removeChapterByChapterId(chapterId)>0;
    }


    @Override
    public boolean removeChapterBySubjectId(Integer subjectId) {
        return chapterMapper.removeChapterBySubjectId(subjectId)>0;
    }
}
