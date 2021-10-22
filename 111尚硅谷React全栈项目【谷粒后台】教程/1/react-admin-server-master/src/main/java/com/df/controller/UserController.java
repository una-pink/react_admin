package com.df.controller;


import com.df.config.StatusCode;
import com.df.pojo.RestResult;
import com.df.pojo.User;
import com.df.service.UserService;
import com.df.utils.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ：MFine
 * @description：TODO
 * @date ：2020/10/5 19:23
 */
@Api(tags = "用户相关操作")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "用户登录", notes = "status为0则登录成功，id参数可以为空")
    @RequestMapping(path = "/login", method = RequestMethod.POST, consumes = {"application/json"})
    public RestResult<User> login(@RequestBody User user) {
        String pw = MD5Util.crypt(user.getPassword());
        User findUser = userService.findOneByName(user.getName());
        if (pw.equals(findUser.getPassword())) {
            return new RestResult<>(true, StatusCode.SUCCESS, "", findUser);
        }
        return new RestResult<>(false, StatusCode.FAILED);

    }

    @ApiOperation(value = "获取所有用户")
    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @ApiOperation(value = "更新用户")
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody User user) {
        user.setId(id);
        if (user.getName().equals("admin")) {
            return ResponseEntity.status(301).body("admin用户不允许修改");
        }
        int update = userService.updateByPrimaryKeySelective(user);
        return ResponseEntity.ok().body(update == 1 ? "success" : "fall");
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        if (id == 1) {
            return ResponseEntity.status(301).body("admin用户不允许删除");
        }
        int delete = userService.deleteByPrimaryKey(id);
        return ResponseEntity.ok().body(delete == 1 ? "success" : "fall");
    }

    @ApiOperation(value = "添加用户")
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        if (user.getName().equals("admin")) {
            return ResponseEntity.status(301).body("admin用户不允许重复添加");
        }
        if (user.getCreateTime() == null) {
            user.setCreateTime(LocalDateTime.now());
        }
        int selective = userService.insertSelective(user);
        return ResponseEntity.ok().body(selective == 1 ? "success" : "fall");
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleStorageFileNotFound(Exception exc) {
        return ResponseEntity.notFound().build();
    }


}