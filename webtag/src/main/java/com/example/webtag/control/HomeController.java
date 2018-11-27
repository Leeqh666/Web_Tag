package com.example.webtag.control;

import com.example.webtag.domain.Shop;
import com.example.webtag.service.ShopService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * create by Lee
 */
@Controller
public class HomeController {
    @Autowired
    ShopService shopService;

    @RequestMapping("/home")
    public ModelAndView home(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum){
        ModelAndView modelAndView = new ModelAndView("home");
        PageInfo<Shop> pageList;
        pageList = shopService.selectAllPage(pageNum,6);
        List<Shop> shopList;
        shopList = pageList.getList();
        int maxNum = pageList.getPages();
        modelAndView.addObject("shopList",shopList);
        modelAndView.addObject("maxNum",maxNum);
        modelAndView.addObject("nowNum",pageNum);
        return modelAndView;
    }
}
