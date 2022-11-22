package www.DCW.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import www.DCW.storage.entity.Warehouse;
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

    //调用入库的过程
    public String saveWarehouse(){


        return null;
    }
    //利用存储过程来获取所有的数据


    //这里调用了存储过程
    @GetMapping("/getAll")
    public List<Warehouse> getAll(){

        List<Warehouse> all = warehouseService.getAll();
        System.out.println(all.toString());

        return all;
    }




}
