package com.example.webtag.control;

import com.example.webtag.domain.JsonReview;
import com.example.webtag.domain.User;
import com.example.webtag.service.JsonReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * create by Lee
 */
@Controller
public class ReviewController {
    @Autowired
    JsonReviewService jsonReviewService;

    @RequestMapping(value = "/review",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> review(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map = new HashMap<String, Object>();
        User user = (User) request.getSession().getAttribute("user");
        if(user != null) {
            map.put("result",1);
        }else {
            map.put("result",0);
        }
        return map;
    }

    @RequestMapping(value = "/writeReview",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> writeReview(HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map = new HashMap<String, Object>();
        User user = (User) request.getSession().getAttribute("user");
        String shopId = request.getParameter("shopId");
        String text = request.getParameter("text");
        String json = request.getParameter("jsonReview");
        JsonReview jsonReview = new JsonReview();
        jsonReview.setUsername(user.getUsername());
        jsonReview.setShopid(shopId);
        jsonReview.setReviewmessage(json);
        jsonReview.setText(text);
        int flag = jsonReviewService.insert(jsonReview);
        if(flag == 1){
            map.put("result",1);
        }else {
            map.put("result",0);
        }
        return map;
    }
}
