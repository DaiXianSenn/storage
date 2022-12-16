package www.DCW.storage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import www.DCW.storage.common.R;
import www.DCW.storage.entity.Permission;
import www.DCW.storage.service.PermissionService;

import java.util.List;

/**
 * Author: JhonDai
 * Date: 2022/11/26/20:08
 * Version: 1.0
 * Description:
 */
@Api("权限管理接口")
@RestController
@Slf4j
@RequestMapping("/permission")
public class PermissionController {


    @Autowired
    private PermissionService permissionService;
    /**
     * 返回一个用户权限管理集合的Json数据
     * @return 权限信息
     */
    @PostMapping ("/get")
    @ApiOperation(value = "根据id获取",notes = "获取id权限的详细信息")
    public R<Permission> getById(@RequestBody Permission userId) {
        return permissionService.getById1(userId.getUserId());
    }

    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "更新权限信息",notes = "将那一行的数据进行更新后传过来更新后的数据 1是代表可以 0是代表不可以")
    public R<String> saveOrUpdatePermission(@RequestBody Permission permission) {
       return permissionService.saveOrUpdatePermission(permission);
    }


    @GetMapping("/getAll")
    @ApiOperation(value = "获取权限信息",notes = "获取所有权限信息")
    public R<List<Permission>> getAll(){
       return permissionService.getAll();
    }
}
