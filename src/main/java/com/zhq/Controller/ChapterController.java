package com.zhq.Controller;

import com.zhq.Service.ChapterService;
import com.zhq.pojo.Chapter;
import com.zhq.pojo.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenchenchen
 * @create 2023-01-28 20:34
 */
@RestController
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    /**
     *
     * @param subjectId
     * @return
     * @Description 查询章节列表
     */
    @GetMapping("/chapterList/{subjectId}")
    public Result getChapterList(@PathVariable Integer subjectId){
        List<Chapter> chapterList = chapterService.findChapterBySubjectId(subjectId);
        return Result.ok(chapterList);
    }

    /**
     *
     * @param chapter
     * @return
     * @Description 添加章节
     */
    @PostMapping("/addChapter")
    public Result addChapter(@RequestBody Chapter chapter){
        if(chapterService.insertChapter(chapter)){
            return Result.ok(null).message("添加成功!");
        }
        return Result.ok(null).message("添加失败!");
    }

    /**
     *
     * @param chapterId
     * @return
     * @Description 删除章节
     */
    @DeleteMapping("/removeChapter/{chapterId}")
    public Result removeChapter(@PathVariable Integer chapterId){
        if(chapterService.removeChapterByChapter(chapterId)){
            return Result.ok(null).message("删除成功!");
        }
        return Result.fail().message("删除失败!");
    }

    /**
     *
     * @param chapter
     * @return
     * @Description 修改章节
     */
    @PutMapping("/updateChapter")
    public Result updateChapter(@RequestBody Chapter chapter){
        if(chapterService.updateChapterTitleByChapterId(chapter.getChapterId(),chapter.getChapterTitle())){
            return Result.ok(null).message("修改成功!");
        }else{
            return Result.fail().message("修改失败!");
        }
    }


}
