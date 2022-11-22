package www.DCW.storage.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import www.DCW.storage.common.R;
import www.DCW.storage.entity.Users;
import www.DCW.storage.service.LoginService;
import www.DCW.storage.pojo.vo.UserVo;


/**
 * Author: JhonDai
 * Date: 2022/10/24/22:25
 * Version: 1.0
 * Description:
 */
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService userService;


    private RedisTemplate redisTemplate;


    @PostMapping("/username")
    public R<String> login(@RequestBody Users users){

        redisTemplate.opsForValue().set("user","userIDtest");

        log.info(users.toString());
        return R.success("登录成功");
    }


}
