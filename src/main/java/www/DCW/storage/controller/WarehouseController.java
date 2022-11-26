package www.DCW.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import www.DCW.storage.common.R;
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


    @PostMapping("/save")
    //调用入库的过程
    public R<String> saveWarehouse(@RequestBody Warehouse warehouse){
        return warehouseService.saveWarehouse(warehouse);
    }



    //这里调用了存储过程
    @GetMapping("/getAll")
    public List<Warehouse> getAll(){

        List<Warehouse> all = warehouseService.getAll();
        System.out.println(all.toString());
        return all;
    }













}
