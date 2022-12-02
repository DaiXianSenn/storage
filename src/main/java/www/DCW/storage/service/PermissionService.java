package www.DCW.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;

import www.DCW.storage.common.R;
import www.DCW.storage.entity.Permission;

import java.util.List;


/**
 * Author: JhonDai
 * Date: 2022/12/01/20:11
 * Version: 1.0
 * Description:
 */

public interface PermissionService extends IService<Permission> {


   // R<Permission> getById(String userId);

    R<Permission> getById1(String userId);

    R<String> saveOrUpdatePermission(Permission permission);

    R<List<Permission>> getAll();
}
