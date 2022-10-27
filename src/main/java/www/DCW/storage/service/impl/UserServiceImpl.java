package www.DCW.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import www.DCW.storage.entity.Users;
import www.DCW.storage.mapper.UserMapper;
import www.DCW.storage.service.UserService;

/**
 * Author: JhonDai
 * Date: 2022/10/24/22:23
 * Version: 1.0
 * Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, Users> implements UserService {

}
