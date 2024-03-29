package com.splade.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.splade.sportplay.bean.QueryInfo;
import com.splade.sportplay.bean.User;
import com.splade.sportplay.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/alluser")
    public String getUserList(QueryInfo queryInfo) {
        // 获取最大列表数
        int numbers = userDao.getUserCounts("%" + queryInfo.getQuery() + "%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();

        List<User> users = userDao.getAllUser("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers", numbers);
        res.put("data", users);
        return JSON.toJSONString(res);
    }

    @RequestMapping("/userstate")
    public String updateUserState(@RequestParam("id") Integer id, @RequestParam("state") Boolean state) {
        int i = userDao.updateState(id, state);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/adduser")
    public String addUser(@RequestBody User user) {
        user.setRole("普通用户");
        user.setState(false);
        int i = userDao.addUser(user);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/deleteuser")
    public String deleteUser(int id) {
        int i = userDao.deleteUser(id);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/getupdateuser")
    public String getUpdateUser(int id) {
        User updateUser = userDao.getUpdateUser(id);
        return JSON.toJSONString(updateUser);
    }

    @RequestMapping("/edituser")
    public String editUser(@RequestBody User user) {
        int i = userDao.editUser(user);
        return i > 0 ? "success" : "error";
    }

}
