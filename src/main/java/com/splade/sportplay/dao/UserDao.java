package com.splade.sportplay.dao;

import com.splade.sportplay.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    public User getUserByMessage(@Param("username") String username, @Param("password") String password);

    public List<User> getAllUser(@Param("username")String username,@Param("pageStart")int PageStart,@Param("pageSize")String pageSize);

    public int getUserContents(@Param("username") String username);
}
