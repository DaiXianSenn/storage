package www.DCW.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import www.DCW.storage.common.R;
import www.DCW.storage.entity.User;

import java.util.List;

/**
 * Author: JhonDai
 * Date: 2022/10/24/22:23
 * Version: 1.0
 * Description:
 */

public interface UserService extends IService<User> {

    R<String> login(User user);

    R<String> saveUser(User user);


    R<String> update(User user);

    R<List<User>> getAll();

}
