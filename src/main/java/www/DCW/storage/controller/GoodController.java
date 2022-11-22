package www.DCW.storage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import www.DCW.storage.common.R;
import www.DCW.storage.entity.Goods;
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
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private GoodsService goodsService;




    /**
     * 模糊查询返回Goods对象 无论是名字规格或者是备注数据都使用了这个
     * @param goods Goods对象
     * @return good 对象
     */
    @PostMapping("/getAll")
    public R<List<Goods>> getAll(@RequestBody Goods goods){
        List<Goods> list = goodsService.getAll(goods);
        return R.success(list);
    }
    @GetMapping("/getAllTest")
    public R<List<Goods>> getAllTest(){
        List<Goods> list = goodsService.list();
        return R.success(list);
    }

    @PostMapping("/saveOrUpdate")
    public R<Boolean> saveOrUpdate(@RequestBody Goods goods){
        if(goods.getGoodsId()==null)return R.error("请输入物料id信息");
        return R.success(goodsService.saveOrUpdate(goods));
    }
    @PostMapping("/delete")
    public R<String> delete(@RequestBody Goods goods){
        goodsService.removeById(goods.getGoodsId());
        return R.success("删除成功");
    }
    /*@GetMapping("/getAllByProcedure")
    public void getAllByProcedure(){






        Map<String,Object> param= new HashMap<>();

        Map<String, Object> all = goodsService.getAll(param);

        System.out.println(all.toString());
    }*/





}
