package com.service;

import com.pojo.Answers;
import com.pojo.PageBean;
import com.pojo.Questions;

import java.util.List;

public interface QuestionsControllerService {
    List<Questions> selectAll(PageBean page);

    Questions selectOne(Integer id);

    int add(Answers answers,Questions questions);

    int add2(Questions questions);
}
