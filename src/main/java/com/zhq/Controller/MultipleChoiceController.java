package com.zhq.Controller;

import com.zhq.Service.MultipleChoiceService;
import com.zhq.pojo.MultipleChoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author ZHQ
 * @create 2023/2/06 13:43
 */

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
    @RequestMapping("/allmultiplechoice/{subject}")
    @ResponseBody
    List<MultipleChoice> allmultiplechoice(@PathVariable String subject){
        ArrayList<MultipleChoice> list = new ArrayList(multipleChoiceService.allmultiplechoice(subject));
        list.stream().forEach(item->{
            if (item.getAnswer().indexOf(",")!=-1 || item.getAnswer().indexOf("，")!=-1){
                item.setAnswers(item.getAnswer().split(",|，"));
            }else {
                item.setAnswers(item.getAnswer().split(""));
            }
        });
        Random random = new Random();
        Collections.shuffle(list,random);

        return list;
    }

    /**
     *
     * @return List<MultipleChoice>
     * @Description 分页查找出所有的多选题
     */
    @ResponseBody
    @RequestMapping("/pageallmultiplechoice/{pageNum}/{pageSize}")
    Map<String,Object> pageallmultiplechoice(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
        return multipleChoiceService.pageallmultiplechoice(pageNum,pageSize);
    }

}
