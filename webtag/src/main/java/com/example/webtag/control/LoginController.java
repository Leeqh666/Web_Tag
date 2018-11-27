package com.example.webtag.control;

import com.example.webtag.domain.User;
import com.example.webtag.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * create by Lee
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map =new HashMap<String,Object>();
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        if(!userName.equals("") && password!=""){
            String check = userService.select(userName);
            if(check!=null&&check.equals(password)){
                User user =new User(userName,password);
                request.getSession().setAttribute("user",user);
                map.put("result","1");
            }else {
                map.put("result","2");
            }
        }else {
            map.put("result", "0");
        }
        return map;
    }

    @RequestMapping("/toLogin")
    public ModelAndView toLogin(){
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @RequestMapping("/toSignUp")
    public ModelAndView toSignUp(){
        ModelAndView modelAndView = new ModelAndView("sign_up");
        return modelAndView;
    }

    @RequestMapping(value = "/sign_up",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> sign_up(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map =new HashMap<String,Object>();
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        String re_password = request.getParameter("re_password");
        if (userService.select_exists(userName) == 0){
            if(password.equals(re_password)){
                User user = new User(userName,password);
                userService.add(user);
                map.put("result","2");
            } else {
                map.put("result","1");
            }
        } else {
            map.put("result","0");
        }
        return map;
    }

    @RequestMapping("/toChangePassword")
    public ModelAndView toChangePassword(){
        ModelAndView modelAndView = new ModelAndView("change_password");
        return modelAndView;
    }

    @RequestMapping(value = "/change_password",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> change_password(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map =new HashMap<String,Object>();
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        String re_password = request.getParameter("re_password");
        if (userService.select_exists(userName) != 0){
            if(password.equals(re_password)){
                User user = new User(userName,password);
                userService.update(user);
                map.put("result","2");
            } else {
                map.put("result","1");
            }
        } else {
            map.put("result","0");
        }
        return map;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> logout(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        request.getSession().setAttribute("user",null);
        if (request.getSession().getAttribute("user") == null){
            map.put("result","1");
        }else {
            map.put("result","0");
        }
        return map;
    }
}
