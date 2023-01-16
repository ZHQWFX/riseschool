package com.zhq.Service;

import com.zhq.pojo.Chinesechoice;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ChinesechoiceService {
    int addchinesechoice(Chinesechoice chinesechoice);
    List<Chinesechoice> allchinesechoice(String type);
}
