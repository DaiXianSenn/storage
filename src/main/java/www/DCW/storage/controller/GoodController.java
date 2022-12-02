package www.DCW.storage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import www.DCW.storage.common.R;
import www.DCW.storage.entity.Goods;
import www.DCW.storage.pojo.dto.GoodsIdWithNameDto;
import www.DCW.storage.service.GoodsService;


import java.util.List;


/**
 * Author: JhonDai
 * Date: 2022/11/05/15:56
 * Version: 1.0
 * Description:
 */
@Transactional
@RestController
@Slf4j
@Api("物料管理接口")
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 模糊查询返回Goods对象 无论是名字规格或者是备注数据都使用了这个
     * @param goods Goods对象
     * @return good 对象
     */
    @ApiOperation(value = "获取所有物料",notes = "获取所有物料")
    @PostMapping("/getAll")
    public R<List<Goods>> getAll(@RequestBody Goods goods){
        List<Goods> list = goodsService.getAll(goods);
        return R.success(list);
    }


    /**
     * 获取物料信息数据 测试
     * @return 所有物料信息
     */
    @GetMapping("/getAllTest")
    public R<List<Goods>> getAllTest(){
        List<Goods> list = goodsService.list();
        return R.success(list);
    }


    /**
     * 获取物料名称或信息
     * @return 物料名称和信息
     */
    @ApiOperation(value = "获取当前数据库物料名称和id",notes = "获取所有物料信息")
    @GetMapping("/getIdAndName")
    public R<List<GoodsIdWithNameDto>> getIdAndName(){
        List<GoodsIdWithNameDto> idAndName = goodsService.getIdAndName();
        System.out.println(idAndName);
        return null;
    }


    /**
     * 物料更新或者删除
     * @param goods 物料对象（前端传来）
     * @return boolean 值
     */
    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "物料更新或者存入",notes = "你如果没有传入id是传入 如果传入id是更新")
    public R<Boolean> saveOrUpdate(@RequestBody Goods goods){
        //if(goods.getGoodsId()==null)return R.error("请输入物料id信息");
        return R.success(goodsService.saveOrUpdate(goods));
    }

    /**
     * 物料删除
     * @param goods 物料对象（前端）
     * @return 删除成功信息 缺少做判断
     */
    @PostMapping("/delete")
    @ApiOperation(value = "根据id删除对应物料",notes = "虽然传入的是Good实体，但实际上只需要对id赋值就好")
    public R<String> delete(@RequestBody Goods goods){

        Goods good = goodsService.getById(goods.getGoodsId());
        if (good==null){
            return R.error("该数据已删除");
        }
        goodsService.removeById(goods.getGoodsId());
        return R.success("删除成功");
    }
}
