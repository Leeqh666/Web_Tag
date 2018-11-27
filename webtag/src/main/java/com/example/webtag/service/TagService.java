package com.example.webtag.service;

import com.example.webtag.domain.Tag;

import java.util.List;

public interface TagService {
    List<Tag> selectAllByShopId(String shopid);
}
