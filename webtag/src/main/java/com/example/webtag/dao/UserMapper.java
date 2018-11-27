package com.example.webtag.dao;

import com.example.webtag.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {
    @Delete({
        "delete from user",
        "where userName = #{username,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String username);

    @Insert({
        "insert into user (userName, password)",
        "values (#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @Select({
        "select",
        "userName, password",
        "from user",
        "where userName = #{username,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="userName", property="username", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(String username);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set password = #{password,jdbcType=VARCHAR}",
        "where userName = #{username,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(User record);

    @Select({
            "select",
            "password",
            "from user",
            "where userName = #{username,jdbcType=VARCHAR}"
    })
    String select(String username);

    @Select({
            "select",
            "count(*)",
            "from user",
            "where userName = #{username,jdbcType=VARCHAR}"
    })
    int select_exists(String username);
}