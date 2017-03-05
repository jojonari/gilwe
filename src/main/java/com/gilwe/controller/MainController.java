package com.gilwe.controller;

import com.gilwe.service.mainServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@Controller
public class MainController {

    private static Logger logger = LoggerFactory.getLogger(MainController.class);


    @Autowired
    mainServiceImpl mainService;


    @PostConstruct
    private void init() {
        try {
            String[] fieldsToMap = { "id", "about", "age_range", "birthday",
                    "context", "cover", "currency", "devices", "education",
                    "email", "favorite_athletes", "favorite_teams",
                    "first_name", "gender", "hometown", "inspirational_people",
                    "installed", "install_type", "is_verified", "languages",
                    "last_name", "link", "locale", "location", "meeting_for",
                    "middle_name", "name", "name_format", "political",
                    "quotes", "payment_pricepoints", "relationship_status",
                    "religion", "security_settings", "significant_other",
                    "sports", "test_group", "timezone", "third_party_id",
                    "updated_time", "verified", "viewer_can_send_gift",
                    "website", "work" };

            Field field = Class.forName(
                    "org.springframework.social.facebook.api.UserOperations")
                    .getDeclaredField("PROFILE_FIELDS");
            field.setAccessible(true);

            Field modifiers = field.getClass().getDeclaredField("modifiers");
            modifiers.setAccessible(true);
            modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            field.set(null, fieldsToMap);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private Facebook facebook;
    private ConnectionRepository connectionRepository;


    public MainController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @RequestMapping("/")
    public ModelAndView mainInit(){
        ModelAndView outView = new ModelAndView();

        outView.addObject("title", "gilwe");
        outView.addObject("name", "이미지주소인가?");

        logger.info("###### {/} : mainInit()");
        outView.setStatus(HttpStatus.OK);
        outView.setViewName("view/main");

//        if (connectionRepository.findPrimaryConnection(Facebook.class) != null) {
//            String [] fields = { "id", "email",  "first_name", "last_name" };
//            User userProfile = facebook.fetchObject("me", User.class, fields);
//            outView.addObject("facebookProfile", userProfile);
//            outView.addObject("name", userProfile.getId());
//            System.out.println(userProfile.toString());
//        }



        return outView;
    }

}
