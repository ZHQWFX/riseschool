package com.zhq.Service;

import com.zhq.pojo.Completion;

import java.util.List;

public interface CompletionService {
    List<Completion> allcompletion(String subject);
    int countcompletion();
}
