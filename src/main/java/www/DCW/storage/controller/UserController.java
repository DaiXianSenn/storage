package www.DCW.storage.controller;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import www.DCW.storage.common.R;
import www.DCW.storage.entity.User;

import www.DCW.storage.service.UserService;

import java.util.List;


/**
 * Author: JhonDai
 * Date: 2022/10/24/22:25
 * Version: 1.0
 * Description:
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


//    @Autowired
//    private RedisTemplate redisTemplate;


    /**
     * 登录用户
     * @param user 用户实体
     * @return 登录信息
     */
    @PostMapping("/login")
    @ApiOperation(value = "登录",notes = "")
    public R<String> login(@RequestBody User user){
        return userService.login(user);
    }

    /**
     * 注册用户
     * @param user 用户实体
     * @return 注册信息
     */
    @PostMapping("/register")
    @ApiOperation(value = "注册",notes = "")
    public R<String> save(@RequestBody User user){
        return userService.saveUser(user);
    }


    /**
     * 用户信息更新
     * @param user 用户实体
     * @return 更新信息
     */
    @PostMapping("/update")
    @ApiOperation(value = "更新用户信息",notes = "")
    public R<String> update(@RequestBody User user){
        return userService.update(user);
    }



    @PostMapping("/getAll")
    @ApiOperation(value = "获取所有用户",notes = "")
    public R<List<User>> getAll(){return userService.getAll();}
}
