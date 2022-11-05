package www.DCW.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import www.DCW.storage.common.R;
import www.DCW.storage.dto.UserDto;
import www.DCW.storage.entity.Users;
import www.DCW.storage.vo.UserVo;

/**
 * Author: JhonDai
 * Date: 2022/10/24/22:23
 * Version: 1.0
 * Description:
 */

public interface LoginService extends IService<Users> {


    public UserVo doLoginByUsername(Users users);
}
