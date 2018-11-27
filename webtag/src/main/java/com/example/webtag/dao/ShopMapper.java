package com.example.webtag.dao;

import com.example.webtag.domain.Shop;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ShopMapper {
    @Delete({
        "delete from shop",
        "where shopId = #{shopid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String shopid);

    @Insert({
        "insert into shop (shopId, shopName, ",
        "description, url, ",
        "image)",
        "values (#{shopid,jdbcType=VARCHAR}, #{shopname,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, ",
        "#{image,jdbcType=VARCHAR})"
    })
    int insert(Shop record);

    @InsertProvider(type=ShopSqlProvider.class, method="insertSelective")
    int insertSelective(Shop record);

    @Select({
        "select",
        "shopId, shopName, description, url, image",
        "from shop",
        "where shopId = #{shopid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="shopId", property="shopid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="shopName", property="shopname", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR)
    })
    Shop selectByPrimaryKey(String shopid);

    @UpdateProvider(type=ShopSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Shop record);

    @Update({
        "update shop",
        "set shopName = #{shopname,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "image = #{image,jdbcType=VARCHAR}",
        "where shopId = #{shopid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Shop record);

    @Select({
            "select",
            "*",
            "from shop"
    })
    @Results({
            @Result(column="shopId", property="shopid", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="shopName", property="shopname", jdbcType=JdbcType.VARCHAR),
            @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
            @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
            @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR)
    })
    List<Shop> selectAll();

}