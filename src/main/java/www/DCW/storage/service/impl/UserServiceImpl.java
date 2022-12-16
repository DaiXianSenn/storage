package www.DCW.storage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import www.DCW.storage.common.R;
import www.DCW.storage.entity.User;
import www.DCW.storage.mapper.UserMapper;
import www.DCW.storage.service.UserService;
import www.DCW.storage.util.WarehouseOddNo.OddNo;

import java.util.List;
import java.util.UUID;

/**
 * Author: JhonDai
 * Date: 2022/10/24/22:23
 * Version: 1.0
 * Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {




    public R<List<User>> getAll(User user){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        lambdaQueryWrapper.like(user.getUserId() != null,User::getUserId,user.getUserId());
        lambdaQueryWrapper.like(user.getName()!=null,User::getName,user.getName());

        //做一些验证
        return R.success(this.list(lambdaQueryWrapper));
    }

    @Override
    public R<User> login(User user) {
        String password = user.getPassword();
        password= DigestUtils.md5DigestAsHex(password.getBytes());

        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();

        userLambdaQueryWrapper.eq(User::getUsername,user.getUsername());

        User one = this.getOne(userLambdaQueryWrapper);

        if (one==null){
            return R.error("账户错误");
        }
        if (!password.equals(one.getPassword())){
            return R.error("密码错误");
        }

        //redisTemplate.opsForValue().set("user","userIDtest");
//        String user1 = (String) redisTemplate.opsForValue().get("user");
//        System.out.println(user1);

        one.setPassword("***");


        return R.success(one);
    }

    @Override
    public R<String> saveUser(User user) {

        //String uuid= UUID.randomUUID().toString();

        String uuid = OddNo.getUserNo();


        user.setUserId(uuid);
        System.out.println(user.getUserId());

        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(password);


        if(this.save(user))
            return R.success("注册成功");
        else
            return R.error("注册失败");
    }

    @Override
    public R<String> update(User user) {
        if (user.getUserId()==null){
            return R.error("用户数据有误");
        }

        if (this.updateById(user)){
            return R.success("修改成功");
        }else
            return R.error("修改失败");
    }
}
