package com.example.webtag.service.impl;

import com.example.webtag.dao.JsonReviewMapper;
import com.example.webtag.domain.JsonReview;
import com.example.webtag.service.JsonReviewService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by Lee
 */
@Service
public class JsonReviewServiceImpl implements JsonReviewService {

    @Autowired
    JsonReviewMapper jsonReviewMapper;
    @Override
    public List<JsonReview> selectAllByShopId(String shopid) {
        return this.jsonReviewMapper.selectAllByShopId(shopid);
    }

    @Override
    public PageInfo<JsonReview> selectAllPageByShopId(String shopid, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<JsonReview> list = selectAllByShopId(shopid);
        PageInfo<JsonReview> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int insert(JsonReview jsonReview) {
        return jsonReviewMapper.insert(jsonReview);
    }
}
