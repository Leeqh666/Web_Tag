package com.example.webtag.dao;

import com.example.webtag.domain.Tag;
import org.apache.ibatis.jdbc.SQL;

public class TagSqlProvider {

    public String insertSelective(Tag record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("tag");
        
        if (record.getShopid() != null) {
            sql.VALUES("shopId", "#{shopid,jdbcType=VARCHAR}");
        }
        
        if (record.getTagname() != null) {
            sql.VALUES("tagName", "#{tagname,jdbcType=VARCHAR}");
        }
        
        if (record.getNum() != null) {
            sql.VALUES("num", "#{num,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Tag record) {
        SQL sql = new SQL();
        sql.UPDATE("tag");
        
        if (record.getNum() != null) {
            sql.SET("num = #{num,jdbcType=INTEGER}");
        }
        
        sql.WHERE("shopId = #{shopid,jdbcType=VARCHAR}");
        sql.WHERE("tagName = #{tagname,jdbcType=VARCHAR}");
        
        return sql.toString();
    }
}