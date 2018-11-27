package com.example.webtag.dao;

import com.example.webtag.domain.JsonReview;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface JsonReviewMapper {
    @Delete({
        "delete from review",
        "where reviewId = #{reviewid,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long reviewid);

    @Insert({
        "insert into review (reviewId, shopId, ",
        "userName, reviewMessage, ",
        "text)",
        "values (#{reviewid,jdbcType=BIGINT}, #{shopid,jdbcType=VARCHAR}, ",
        "#{username,jdbcType=VARCHAR}, #{reviewmessage,jdbcType=VARCHAR}, ",
        "#{text,jdbcType=VARCHAR})"
    })
    int insert(JsonReview record);

    @InsertProvider(type=JsonReviewSqlProvider.class, method="insertSelective")
    int insertSelective(JsonReview record);

    @Select({
        "select",
        "reviewId, shopId, userName, reviewMessage, text",
        "from review",
        "where reviewId = #{reviewid,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="reviewId", property="reviewid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="shopId", property="shopid", jdbcType=JdbcType.VARCHAR),
        @Result(column="userName", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="reviewMessage", property="reviewmessage", jdbcType=JdbcType.VARCHAR),
        @Result(column="text", property="text", jdbcType=JdbcType.VARCHAR)
    })
    JsonReview selectByPrimaryKey(Long reviewid);

    @UpdateProvider(type=JsonReviewSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(JsonReview record);

    @Update({
        "update review",
        "set shopId = #{shopid,jdbcType=VARCHAR},",
          "userName = #{username,jdbcType=VARCHAR},",
          "reviewMessage = #{reviewmessage,jdbcType=VARCHAR},",
          "text = #{text,jdbcType=VARCHAR}",
        "where reviewId = #{reviewid,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(JsonReview record);

    @Select({
            "select",
            "*",
            "from review",
            "where shopId=#{shopid}"
    })
    @Results({
            @Result(column="reviewId", property="reviewid", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="shopId", property="shopid", jdbcType=JdbcType.VARCHAR),
            @Result(column="userName", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="reviewMessage", property="reviewmessage", jdbcType=JdbcType.VARCHAR),
            @Result(column="text", property="text", jdbcType=JdbcType.VARCHAR)
    })
    List<JsonReview> selectAllByShopId(String shopid);
}