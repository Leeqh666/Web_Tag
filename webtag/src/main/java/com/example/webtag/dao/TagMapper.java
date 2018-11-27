package com.example.webtag.dao;

import com.example.webtag.domain.Tag;
import com.example.webtag.domain.TagKey;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface TagMapper {
    @Delete({
        "delete from tag",
        "where shopId = #{shopid,jdbcType=VARCHAR}",
          "and tagName = #{tagname,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(TagKey key);

    @Insert({
        "insert into tag (shopId, tagName, ",
        "num)",
        "values (#{shopid,jdbcType=VARCHAR}, #{tagname,jdbcType=VARCHAR}, ",
        "#{num,jdbcType=INTEGER})"
    })
    int insert(Tag record);

    @InsertProvider(type=TagSqlProvider.class, method="insertSelective")
    int insertSelective(Tag record);

    @Select({
        "select",
        "shopId, tagName, num",
        "from tag",
        "where shopId = #{shopid,jdbcType=VARCHAR}",
          "and tagName = #{tagname,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="shopId", property="shopid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="tagName", property="tagname", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER)
    })
    Tag selectByPrimaryKey(TagKey key);

    @UpdateProvider(type=TagSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Tag record);

    @Update({
        "update tag",
        "set num = #{num,jdbcType=INTEGER}",
        "where shopId = #{shopid,jdbcType=VARCHAR}",
          "and tagName = #{tagname,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Tag record);

    @Select({
            "select",
            "*",
            "from tag",
            "where shopId = #{shopid}"
    })
    @Results({
            @Result(column="shopId", property="shopid", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="tagName", property="tagname", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="num", property="num", jdbcType=JdbcType.INTEGER)
    })
    List<Tag> selectAllByShopId(String shopid);

}