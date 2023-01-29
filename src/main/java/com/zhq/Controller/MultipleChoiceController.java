package com.zhq.Controller;

import com.zhq.Service.MultipleChoiceService;
import com.zhq.pojo.MultipleChoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/multiplechoice")
public class MultipleChoiceController {

    @Autowired
    MultipleChoiceService multipleChoiceService;

    /**
     *
     * @return List<MultipleChoice>
     * @Description 查找出所有的多选题
     */
    @RequestMapping("/allmultiplechoice")
    @ResponseBody
    List<MultipleChoice> allmultiplechoice(){
        return multipleChoiceService.allmultiplechoice();
    }
}
