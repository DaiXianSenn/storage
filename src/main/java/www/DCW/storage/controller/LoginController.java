package www.DCW.storage.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import www.DCW.storage.common.R;
import www.DCW.storage.entity.Users;
import www.DCW.storage.service.LoginService;
import www.DCW.storage.vo.UserVo;


/**
 * Author: JhonDai
 * Date: 2022/10/24/22:25
 * Version: 1.0
 * Description:
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService userService;




    @PostMapping("/username")
    public R<UserVo> login(@RequestBody Users users){

        return R.success(userService.doLoginByUsername(users));
    }
}
