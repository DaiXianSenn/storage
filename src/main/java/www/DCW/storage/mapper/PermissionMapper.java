package www.DCW.storage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import www.DCW.storage.entity.Permission;

/**
 * Author: JhonDai
 * Date: 2022/12/01/20:12
 * Version: 1.0
 * Description:
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    Permission getById(String userId);

}
