package www.DCW.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import www.DCW.storage.entity.Users;
import www.DCW.storage.pojo.vo.UserVo;

/**
 * Author: JhonDai
 * Date: 2022/10/24/22:23
 * Version: 1.0
 * Description:
 */

public interface LoginService extends IService<Users> {


    UserVo doLoginByUsername(Users users);
}
