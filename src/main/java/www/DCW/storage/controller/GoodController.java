package www.DCW.storage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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


    @GetMapping("/getAll")
    public void getAll(){

        List<Goods> list = goodsService.list();

        System.out.println(list);
    }




}
