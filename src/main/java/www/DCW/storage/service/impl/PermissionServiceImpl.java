package www.DCW.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.DCW.storage.common.R;
import www.DCW.storage.entity.Permission;
import www.DCW.storage.mapper.PermissionMapper;
import www.DCW.storage.service.PermissionService;
import www.DCW.storage.service.UserService;

import java.util.List;

/**
 * Author: JhonDai
 * Date: 2022/12/01/20:12
 * Version: 1.0
 * Description:
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>implements PermissionService {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public R<Permission> getById1(String userId) {

        if (userService.getById(userId)==null)
            return R.error("无此用户");

        Permission permission = permissionMapper.getById(userId);

        if (permission==null)
            return R.error("并无此用户的权限信息");
        else
            return R.success(permission);
    }

    @Override
    public R<String> saveOrUpdatePermission(Permission permission) {
        if (this.saveOrUpdate(permission))
            return R.success("操作成功");
        else
            return R.error("操作失败");
    }

    @Override
    public R<List<Permission>> getAll(){
        List<Permission> list = this.list();
        if(list!=null){
            return R.success(list);
        }else
            return R.error("操作失败");
    }
}
