package com.gilwe.controller;

import com.gilwe.service.mainServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private static Logger logger = LoggerFactory.getLogger(MainController.class);


    @Autowired
    mainServiceImpl mainService;

    @RequestMapping("/")
    public ModelAndView mainInit(){
        ModelAndView outView = new ModelAndView();

        outView.addObject("title", "gilwe");

        logger.info("###### {/} : mainInit()");
        outView.setStatus(HttpStatus.OK);
        outView.setViewName("view/main");
        return outView;
    }


}
