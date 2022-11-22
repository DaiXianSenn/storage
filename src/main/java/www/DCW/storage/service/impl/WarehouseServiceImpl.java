package www.DCW.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.DCW.storage.common.R;
import www.DCW.storage.entity.Warehouse;
import www.DCW.storage.mapper.WarehouseMapper;
import www.DCW.storage.pojo.vo.WareahouseVo;
import www.DCW.storage.service.GoodsService;
import www.DCW.storage.service.WarehouseService;

import java.util.List;

/**
 * Author: JhonDai
 * Date: 2022/11/12/9:35
 * Version: 1.0
 * Description:
 */
@Slf4j
@Service
public class WarehouseServiceImpl extends ServiceImpl<WarehouseMapper, Warehouse> implements WarehouseService {

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Autowired
    private GoodsService goodsService;
    @Override
    public List<Warehouse> getAll() {
        return warehouseMapper.getAll();
    }

    /**
     * 出入库开单
     * @param  wareahouseVo
     * @return 操作信息："操作成功" or "操作失败"
     */
    @Override
    public R<String> inWarehouse(WareahouseVo wareahouseVo) {

        String goodId;
        if (wareahouseVo.getGoodName() == null) return R.error("请选择物料");
        else {
            goodId = goodsService.getGoodsIdByGoodsName(wareahouseVo.getGoodName());
        }
        goodsService.getById(goodId);



        //Warehouse.builder().id();




        return null;
    }

    @Override
    public String saveWarehouse(Warehouse warehouse) {



        if (warehouse.getGoodId()==null) return "请选择物料";


        String s = this.saveWarehouse(warehouse);

        return "操作成功";
    }


}
