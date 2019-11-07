package com.example.demo.controller;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/curd", method = { RequestMethod.GET, RequestMethod.POST })
public class UserController {
    @Autowired
    private UserService userservice;

    @RequestMapping("/listuser")
    @ResponseBody
    public List<User> ListUser() {
        return userservice.ListUser();
    }

    //对数据库进行查找操作
    @RequestMapping("/listuserbyname")
    @ResponseBody
    public List<User> ListUserByName(String name) {

        return userservice.findByName(name);
    }//

    //对数据库进行的删除操作
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int id) {
        int result = userservice.delete(id);
        if (result >= 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    //对数据进行修改的操作
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(User user) {
        int result = userservice.Update(user);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    //对数据库进行增加字段操作
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public User insert(User user) {
        return userservice.insertUser(user);
    }
}
