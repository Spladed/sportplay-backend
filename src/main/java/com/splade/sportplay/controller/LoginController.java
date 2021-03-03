package com.splade.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.splade.sportplay.bean.User;
import com.splade.sportplay.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/login")
    public String login(@RequestBody User user){
        String flag="error";
        Map<String, Object> map = new HashMap<>();
        User u=userDao.getUserByMessage(user.getUsername(),user.getPassword());
        if(u!=null){
            flag="ok";
        }
        map.put("flag",flag);
        map.put("user",u);
        return JSON.toJSONString(map);
    }

}
