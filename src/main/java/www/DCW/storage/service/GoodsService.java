package www.DCW.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;

import www.DCW.storage.entity.Goods;
import www.DCW.storage.pojo.dto.GoodsIdWithNameDto;

import java.util.List;
import java.util.Map;

/**
 * Author: JhonDai
 * Date: 2022/11/05/16:00
 * Version: 1.0
 * Description:
 */

public interface GoodsService extends IService<Goods> {


    Map<String, Object> getAll(Map<String, Object> param);
    List<Goods> getAll(Goods goods);

    String getGoodsIdByGoodsName(String goodName);

    List<GoodsIdWithNameDto> getIdAndName();
}
