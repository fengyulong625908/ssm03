package com.service.impl;

import com.mapper.AnswersMapper;
import com.mapper.QuestionsMapper;
import com.pojo.*;
import com.service.QuestionsControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class QuestionsControllerServiceImpl implements QuestionsControllerService {
    @Autowired
    private QuestionsMapper mapper;
    @Autowired
    private AnswersMapper mapper1;

    @Override
    public List<Questions> selectAll(PageBean page) {
        int count= (int) mapper.countByExample(null);
        int size= page.getSize();
        int total=count%size==0?(count/size):(count/size+1);
        page.setCount(count);
        page.setTotalPage(total);
        QuestionsExample e=new QuestionsExample();
        e.limit((page.getCurrPage()-1)*size,size);
        return    mapper.selectByExample(e);


    }

    @Override
    public Questions selectOne(Integer id) {
        Questions questions = mapper.selectByPrimaryKey(id);
        AnswersExample e=new AnswersExample();
        e.createCriteria().andQidEqualTo(questions.getId());
        List<Answers> answers = mapper1.selectByExample(e);

        questions.setAnswers(answers);

        return questions;
    }

    @Override
    public int add(Answers answers, Questions questions) {
        int i=0;
        QuestionsExample e=new QuestionsExample();
        e.createCriteria().andTitleEqualTo(questions.getTitle());
        List<Questions> questions2 = mapper.selectByExample(e);
        for (Questions questions1:questions2){
            questions1.setAnswercount(questions1.getAnswercount()+1);
            mapper.updateByPrimaryKeySelective(questions1);
            answers.setQid(questions1.getId());
            i = mapper1.insertSelective(answers);

        }
            return i;
    }

    @Override
    public int add2(Questions questions) {
        questions.setLastmodified(new Date());
      return   mapper.insertSelective(questions);
    }
}
