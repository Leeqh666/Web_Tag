package com.example.webtag.service;

import com.example.webtag.domain.JsonReview;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface JsonReviewService {
    List<JsonReview> selectAllByShopId(String shopid);
    PageInfo<JsonReview> selectAllPageByShopId(String shopid,int pageNum,int pageSize);
    int insert(JsonReview jsonReview);
}
