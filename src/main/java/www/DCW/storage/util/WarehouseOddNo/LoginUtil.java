package www.DCW.storage.util.WarehouseOddNo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Author: JhonDai
 * Date: 2022/11/25/10:16
 * Version: 1.0
 * Description:
 */
@Component
public class LoginUtil {


    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;


    /**
     * 判断是否登录
     * @param loginId 查询的登录id
     * @return true-存在 false-不存在
     */
    public boolean isLogin(String loginId){
        Boolean res=redisTemplate.hasKey(loginId);
        if (res==null){
            return false;
        }
        return res;
    }

}
