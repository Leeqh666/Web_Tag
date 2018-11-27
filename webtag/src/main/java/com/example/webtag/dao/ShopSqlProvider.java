package com.example.webtag.dao;

import com.example.webtag.domain.Shop;
import org.apache.ibatis.jdbc.SQL;

public class ShopSqlProvider {

    public String insertSelective(Shop record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("shop");
        
        if (record.getShopid() != null) {
            sql.VALUES("shopId", "#{shopid,jdbcType=VARCHAR}");
        }
        
        if (record.getShopname() != null) {
            sql.VALUES("shopName", "#{shopname,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.VALUES("url", "#{url,jdbcType=VARCHAR}");
        }
        
        if (record.getImage() != null) {
            sql.VALUES("image", "#{image,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Shop record) {
        SQL sql = new SQL();
        sql.UPDATE("shop");
        
        if (record.getShopname() != null) {
            sql.SET("shopName = #{shopname,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.SET("url = #{url,jdbcType=VARCHAR}");
        }
        
        if (record.getImage() != null) {
            sql.SET("image = #{image,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("shopId = #{shopid,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}