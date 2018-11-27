package com.example.webtag.service.impl;

import com.example.webtag.dao.TagMapper;
import com.example.webtag.domain.Tag;
import com.example.webtag.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by Lee
 */

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagMapper tagMapper;

    @Override
    public List<Tag> selectAllByShopId(String shopid) {
        return this.tagMapper.selectAllByShopId(shopid);
    }
}
