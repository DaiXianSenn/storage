package www.DCW.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.DCW.storage.common.R;
import www.DCW.storage.entity.Goods;
import www.DCW.storage.entity.Warehouse;
import www.DCW.storage.mapper.WarehouseMapper;
import www.DCW.storage.pojo.tto.GoodsInfoTto;
import www.DCW.storage.pojo.vo.WarehouseVoList;
import www.DCW.storage.service.GoodsService;
import www.DCW.storage.service.WarehouseService;
import www.DCW.storage.util.WarehouseOddNo.OddNo;

import java.util.List;
import java.util.stream.Collectors;

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



    //入仓操作
    @Override
    public R<String> saveWarehouse(Warehouse warehouse) {

        if (warehouse.getGoodId() == null) return R.error("请选择物料");

        if (warehouse.getId() == null) {
            warehouse.setId(OddNo.getWarehouseOddNo());
            log.info("无仓单信息，正在自动生成");
        }

        Goods goods = goodsService.getById(warehouse.getGoodId());
        if (goods.getAmount() < warehouse.getAmount() && warehouse.getType() == 2) {
            return R.error("操作失败，仓库物料数目不足");
        }

        String goodId = warehouse.getGoodId();
        warehouseMapper.saveWarehouse(warehouse);
        return R.success("操作成功");
    }

    @Override
    public R<String> saveWarehouseByList(WarehouseVoList warehouseVoList) {

        if (warehouseVoList.getId() == null) {
            warehouseVoList.setId(OddNo.getWarehouseOddNo());
            log.info("无仓单信息，正在自动生成");
        }
        List<GoodsInfoTto> goodsInfoTtoList=warehouseVoList.getGoodsInfoTtoList();

        List<Warehouse> warehousesCollect = goodsInfoTtoList.stream().map((item) -> {

            Warehouse warehouse = Warehouse.builder()
                    .id(warehouseVoList.getId())
                    .times(warehouseVoList.getTimes())
                    .type(warehouseVoList.getType())
                    .goodId(item.getGoodId())
                    .userId(warehouseVoList.getUserId())
                    .date(warehouseVoList.getDate())
                    .amount(item.getAmount())
                    .remarks(warehouseVoList.getRemarks()).build();

            return warehouse;
        }).collect(Collectors.toList());


        for (Warehouse item : warehousesCollect) {
            this.saveWarehouse(item);
        }

        return R.success("批量操作成功");
    }


}

/*        warehouse.getId()
        warehouse.getTimes()
        warehouse.getType()
        warehouse.getGoodId()
        warehouse.getUserId()
        warehouse.getDate()
        warehouse.getAmount()
        warehouse.getRemarks()
                warehouse.getId(),
                warehouse.getTimes(),
                warehouse.getType(),
                warehouse.getGoodId(),
                warehouse.getUserId(),
                "2022-01-02",
                warehouse.getAmount(),
                warehouse.getRemarks()*/
//    /**
//     * 出入库开单
//     * @param  wareahouseVo 前端实体接口
//     * @return 操作信息："操作成功" or "操作失败"
//     */
//    @Override
//    public R<String> inWarehouse(WareahouseVo wareahouseVo) {
//
//        String goodId;
//        if (wareahouseVo.getGoodName() == null) return R.error("请选择物料");
//        else {
//            goodId = goodsService.getGoodsIdByGoodsName(wareahouseVo.getGoodName());
//        }
//        goodsService.getById(goodId);
//        //Warehouse.builder().id();
//        return null;
//    }