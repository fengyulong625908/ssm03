package com.controller;

import com.pojo.Answers;
import com.pojo.PageBean;
import com.pojo.Questions;
import com.service.QuestionsControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/con")
public class QuestionsController {
    @Autowired
    private QuestionsControllerService service;
    @RequestMapping("/show")
    public ModelAndView show(ModelAndView m, PageBean page){
     List<Questions> questions= service.selectAll(page);
        m.addObject("questions",questions);
        m.addObject("page",page);
        m.setViewName("show");
        return m;

    }
    @RequestMapping("/show1")
    public ModelAndView show1(ModelAndView m,Integer id){
       Questions questions= service.selectOne(id);
        m.addObject("questions",questions);

        m.setViewName("details");
        return m;

    }
    @RequestMapping("/add")
    public String add(Answers answers,Questions questions){
        answers.setAnsdate(new Date());
        int i= service.add(answers,questions);
        System.out.println(questions.getTitle());

        return "redirect:/con/show";

    }
    @RequestMapping("/add1")
    public String add1(){
        return "add";
    }
    @RequestMapping("/add2")
    public String add2(Questions questions){
     int i=  service.add2(questions);
     return "redirect:/con/show";
    }
}
