package com.example.webtag.dao;

import com.example.webtag.domain.JsonReview;
import org.apache.ibatis.jdbc.SQL;

public class JsonReviewSqlProvider {

    public String insertSelective(JsonReview record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("review");
        
        if (record.getReviewid() != null) {
            sql.VALUES("reviewId", "#{reviewid,jdbcType=BIGINT}");
        }
        
        if (record.getShopid() != null) {
            sql.VALUES("shopId", "#{shopid,jdbcType=VARCHAR}");
        }
        
        if (record.getUsername() != null) {
            sql.VALUES("userName", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getReviewmessage() != null) {
            sql.VALUES("reviewMessage", "#{reviewmessage,jdbcType=VARCHAR}");
        }
        
        if (record.getText() != null) {
            sql.VALUES("text", "#{text,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(JsonReview record) {
        SQL sql = new SQL();
        sql.UPDATE("review");
        
        if (record.getShopid() != null) {
            sql.SET("shopId = #{shopid,jdbcType=VARCHAR}");
        }
        
        if (record.getUsername() != null) {
            sql.SET("userName = #{username,jdbcType=VARCHAR}");
        }
        
        if (record.getReviewmessage() != null) {
            sql.SET("reviewMessage = #{reviewmessage,jdbcType=VARCHAR}");
        }
        
        if (record.getText() != null) {
            sql.SET("text = #{text,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("reviewId = #{reviewid,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}