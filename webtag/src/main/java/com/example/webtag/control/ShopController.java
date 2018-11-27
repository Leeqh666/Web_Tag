package com.example.webtag.control;

import com.example.webtag.domain.JsonReview;
import com.example.webtag.domain.Shop;
import com.example.webtag.domain.Tag;
import com.example.webtag.entity.ReviewMessage;
import com.example.webtag.service.JsonReviewService;
import com.example.webtag.service.ShopService;
import com.example.webtag.service.TagService;
import com.github.pagehelper.PageInfo;
import entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import utils.MyJsonProcess;

import java.util.ArrayList;
import java.util.List;

/**
 * create by Lee
 */
@Controller
public class ShopController {
    @Autowired
    ShopService shopService;
    @Autowired
    JsonReviewService jsonReviewService;
    @Autowired
    TagService tagService;

    @RequestMapping(value = "/shop/",params = "shopid")
    public ModelAndView shop(@RequestParam(value = "shopid")String shopid,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum){
        ModelAndView modelAndView = new ModelAndView("shop");
        //商店信息
        Shop shop = shopService.select(shopid);
        modelAndView.addObject("shop",shop);
        //评论信息
        PageInfo<JsonReview> pageList;
        pageList = jsonReviewService.selectAllPageByShopId(shopid,pageNum,5);
        List<JsonReview> reviewList = pageList.getList();
        modelAndView.addObject("reviewList",reviewList);
        List<ReviewMessage> messageList = new ArrayList<ReviewMessage>();
        for(JsonReview jsonReview : reviewList){
            MyJsonProcess myJsonProcess = new MyJsonProcess();
            Review review = myJsonProcess.getReview(jsonReview.getReviewmessage());
            messageList.add(new ReviewMessage(jsonReview,review));
        }
        modelAndView.addObject("messageList",messageList);
        //标签信息
        List<Tag> tagList = tagService.selectAllByShopId(shopid);
        modelAndView.addObject("tagList",tagList);
        //分页控制
        int maxNum = pageList.getPages();
        modelAndView.addObject("maxNum",maxNum);
        modelAndView.addObject("nowNum",pageNum);
        return modelAndView;
    }
}
