package www.DCW.storage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import www.DCW.storage.entity.Goods;
import www.DCW.storage.mapper.GoodsMapper;
import www.DCW.storage.pojo.dto.GoodsIdWithNameDto;
import www.DCW.storage.service.GoodsService;

import java.util.List;
import java.util.Map;

/**
 * Author: JhonDai
 * Date: 2022/11/05/16:00
 * Version: 1.0
 * Description:
 */
@Service
public class GoodServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {


    private final GoodsMapper goodsMapper;

    public GoodServiceImpl(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    @Override
    public Map<String, Object> getAll(Map<String, Object> param) {

        return goodsMapper.getAll(param);
    }

    @Override
    public List<Goods> getAll(Goods goods) {
        LambdaQueryWrapper<Goods> goodsLambdaQueryWrapper = new LambdaQueryWrapper<>();
        goodsLambdaQueryWrapper.like(goods.getGoodsId()!=null,Goods::getGoodsId,goods.getGoodsId());
        goodsLambdaQueryWrapper.like(goods.getGoodsName()!=null,Goods::getGoodsName,goods.getGoodsName());
        goodsLambdaQueryWrapper.like(goods.getType()!=null,Goods::getType,goods.getType());
        goodsLambdaQueryWrapper.like(goods.getRemarks()!=null,Goods::getRemarks,goods.getRemarks());
        List<Goods> list = this.list(goodsLambdaQueryWrapper);
        return list;
    }

    @Override
    public String getGoodsIdByGoodsName(String goodName) {
        return goodsMapper.getGoodsIdByGoodsName(goodName);
    }

    @Override
    public List<GoodsIdWithNameDto> getIdAndName() {

        return  goodsMapper.getIdAndName();
    }
}
