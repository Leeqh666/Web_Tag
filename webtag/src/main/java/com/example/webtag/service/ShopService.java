package com.example.webtag.service;

import com.example.webtag.domain.Shop;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ShopService {
    List<Shop> selectAll();
    PageInfo<Shop> selectAllPage(int pageNum, int pageSize);
    Shop select(String shopId);
}
