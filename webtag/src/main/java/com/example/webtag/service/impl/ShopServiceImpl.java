package com.example.webtag.service.impl;

import com.example.webtag.dao.ShopMapper;
import com.example.webtag.domain.Shop;
import com.example.webtag.service.ShopService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by Lee
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    ShopMapper shopMapper;

    @Override
    public List<Shop> selectAll() {
        return shopMapper.selectAll();
    }

    @Override
    public PageInfo<Shop> selectAllPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Shop> list = selectAll();
        PageInfo<Shop> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Shop select(String shopId) {
        return shopMapper.selectByPrimaryKey(shopId);
    }
}
