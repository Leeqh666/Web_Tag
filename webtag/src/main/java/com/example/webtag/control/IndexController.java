package com.example.webtag.control;

import com.example.webtag.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * create by Lee
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("index");
        User user = (User) request.getSession().getAttribute("user");
        boolean flag;
        if(user == null){
            flag = false;
        }else {
            flag = true;
            modelAndView.addObject("user",user);
        }
        modelAndView.addObject("flag",flag);
        return modelAndView;
    }
}

