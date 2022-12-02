package www.DCW.storage.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import www.DCW.storage.common.R;
import www.DCW.storage.entity.Warehouse;
import www.DCW.storage.pojo.vo.WarehouseVoList;
import www.DCW.storage.service.WarehouseService;

import java.util.List;

/**
 * Author: JhonDai
 * Date: 2022/11/11/12:07
 * Version: 1.0
 * Description:
 */

@RestController
@RequestMapping("/Warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;


    /**
     * 出仓和入仓过程
     * @param warehouse 仓单实体
     * @return 操作信息
     */
    @PostMapping("/save")
    //调用入库的过程
    @ApiOperation(value = "单物料出库入库",notes = "type 类型(1：入库 2：出库)")
    public R<String> saveWarehouse(@RequestBody Warehouse warehouse){
        return warehouseService.saveWarehouse(warehouse);
    }



    //这里调用了存储过程
    @GetMapping("/getAll")
    @ApiOperation(value = "获取所有仓单",notes = "")
    public List<Warehouse> getAll(){
        List<Warehouse> all = warehouseService.getAll();
        System.out.println(all.toString());
        return all;
    }


    /**
     * ceshi
     */
    /**
     * 批量物料
     * @param warehouse 仓单实体
     * @return 操作信息
     */
    @PostMapping("/saveList")
    @Transactional(rollbackFor = Exception.class)//指定回滚 ，遇到异常时Exception时回滚
    @ApiOperation(value = "多物料出库入库（List）",notes = "type 类型(1：入库 2：出库) 要注意结构")
    public R<String> saveWarehouseByList(@RequestBody WarehouseVoList warehouse){
        return warehouseService.saveWarehouseByList(warehouse);
    }

}
