package com.yg.mybatisinformation.controller;

import com.yg.mybatisinformation.pojo.User;
import com.yg.mybatisinformation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/UserById")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/QueryById{id}" )
    public User UserById(@PathVariable("id")Integer id){
        return userService.selectUserById(id);
    }
}
