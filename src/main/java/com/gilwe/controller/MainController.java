package com.gilwe.controller;

import com.gilwe.service.mainServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class MainController {

    private static Logger logger = LoggerFactory.getLogger(MainController.class);


    @Autowired
    mainServiceImpl mainService;

    @RequestMapping("/")
    public ModelAndView mainInit(@RequestParam Map<String, Object> pMap){
        ModelAndView outView = new ModelAndView();

        outView.addAllObjects(mainService.getMainSuggestList(pMap));
        outView.setViewName("view/main");

        return outView;
    }

    @RequestMapping("/road/{road_id}")
    public ModelAndView dog(@PathVariable String road_id) {

        ModelAndView outView = new ModelAndView();

        outView.addAllObjects(mainService.getRoadInfo(road_id));
        outView.setViewName("view/road");

        return outView;
    }
}
