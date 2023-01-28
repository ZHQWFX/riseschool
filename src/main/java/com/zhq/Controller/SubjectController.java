package com.zhq.Controller;

import com.zhq.Service.SubjectService;
import com.zhq.pojo.Result;
import com.zhq.pojo.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenchenchen
 * @create 2023-01-28 20:17
 */
@RestController
public class SubjectController {

    @Resource
    private SubjectService subjectService;

    /**
     *
     * @param accountUser
     * @return
     * @Description 查询科目列表
     */
    @GetMapping("/subjectList/{accountUser}")
    public Result getSubjectList(@PathVariable String accountUser){
        List<Subject> subjects = subjectService.findSubjectByAccountUser(accountUser);
        return Result.ok(subjects);
    }

    /**
     *
     * @param subject
     * @return
     * @Description 添加科目
     */
    @PostMapping("/addSubject")
    public Result addSubject(@RequestBody Subject subject){
        if(subjectService.insertSubject(subject)){
            return Result.ok(null).message("添加成功!");
        }
        return Result.fail().message("添加失败");
    }

    /**
     *
     * @param subjectId
     * @return
     * @Description 删除科目
     */
    @DeleteMapping("/removeSubject/{subjectId}")
    public Result removeSubject(@PathVariable Integer subjectId){
        if(subjectService.removeSubjectBySubjectId(subjectId)){
            return Result.ok(null).message("删除成功!");
        }
        return Result.fail().message("删除失败!");
    }

    /**
     *
     * @param subject
     * @return
     * @Description 更改科目名
     */
    @PutMapping("/updateSubjectName")
    public Result updateSubjectName(@RequestBody Subject subject){
        if(subjectService.updateSubjectName(subject.getSubjectId(),subject.getSubjectName())){
            return Result.ok(null).message("修改成功!");
        }
        return Result.fail().message("修改失败!");
    }


}
