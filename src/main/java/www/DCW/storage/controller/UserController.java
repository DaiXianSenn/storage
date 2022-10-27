package www.DCW.storage.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import www.DCW.storage.common.R;
import www.DCW.storage.entity.Users;
import www.DCW.storage.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: JhonDai
 * Date: 2022/10/24/22:25
 * Version: 1.0
 * Description:
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;



    public R<Users> login(HttpServletRequest request, @RequestBody Users employee){


        return R.success(null);
    }
}
