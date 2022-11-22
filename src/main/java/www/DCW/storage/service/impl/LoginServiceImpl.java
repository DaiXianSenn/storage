package www.DCW.storage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;
import www.DCW.storage.entity.Users;
import www.DCW.storage.mapper.UserMapper;
import www.DCW.storage.service.LoginService;
import www.DCW.storage.pojo.vo.UserVo;

/**
 * Author: JhonDai
 * Date: 2022/10/24/22:23
 * Version: 1.0
 * Description:
 */
@Service
public class LoginServiceImpl extends ServiceImpl<UserMapper, Users> implements LoginService {




    @Override
    public UserVo doLoginByUsername(Users users) {

        LambdaQueryWrapper<Users> userLambdaQueryWrapper = new LambdaQueryWrapper<>();

        userLambdaQueryWrapper.eq(Users::getUsername,users.getUsername());

        Users one = this.getOne(userLambdaQueryWrapper);




        System.out.println(one.toString());
        return new UserVo(one);
    }
}
