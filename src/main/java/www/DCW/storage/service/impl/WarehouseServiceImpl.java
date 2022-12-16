package www.DCW.storage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.DCW.storage.common.R;
import www.DCW.storage.entity.Goods;
import www.DCW.storage.entity.Warehouse;
import www.DCW.storage.mapper.WarehouseMapper;
import www.DCW.storage.pojo.dto.WarehouseSumDTO;
import www.DCW.storage.pojo.tto.GoodsInfoTto;
import www.DCW.storage.pojo.tto.WarehouseSumTTO;
import www.DCW.storage.pojo.vo.WarehouseSumVo;
import www.DCW.storage.pojo.vo.WarehouseVoList;
import www.DCW.storage.service.GoodsService;
import www.DCW.storage.service.WarehouseService;
import www.DCW.storage.util.WarehouseOddNo.OddNo;

import java.util.ArrayList;
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

    @Override
    public R<List<Warehouse>> getAllToTable(String goodsId,String timeStart,String timeEnd) {

        LambdaQueryWrapper<Warehouse> warehouseLambdaQueryWrapper = new LambdaQueryWrapper<>();
        warehouseLambdaQueryWrapper.ge(timeStart!=null,Warehouse::getDate,timeStart);
        warehouseLambdaQueryWrapper.le(timeEnd!=null,Warehouse::getDate,timeEnd);
        warehouseLambdaQueryWrapper.eq(goodsId!=null,Warehouse::getGoodId,goodsId);
        return R.success(this.list(warehouseLambdaQueryWrapper));
    }


    //入仓操作
    @Override
    public R<String> saveWarehouse(Warehouse warehouse) {

        System.out.println("---------------------------"+warehouse);
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
            R<String> stringR = this.saveWarehouse(item);
            System.out.println(stringR);
        }

        return R.success("批量操作成功");
    }

    @Override
    public R<WarehouseSumDTO> getGoodSum(WarehouseSumVo warehouseTableVo) {
        LambdaQueryWrapper<Warehouse> warehouseLambdaQueryWrapper = new LambdaQueryWrapper<>();
        warehouseLambdaQueryWrapper.ge(warehouseTableVo.getStartTime()!=null,Warehouse::getDate,warehouseTableVo.getStartTime());
        warehouseLambdaQueryWrapper.le(warehouseTableVo.getEndTime()!=null,Warehouse::getDate,warehouseTableVo.getEndTime());
        List<Warehouse> list = this.list(warehouseLambdaQueryWrapper);


        List<WarehouseSumTTO> warehouseSumTTOS = new ArrayList<>();
        List<Goods> goods = goodsService.getAll(new Goods());
        int size= goods.size();
        //初始化变量
        for(Goods goodsTemp:goods){
            WarehouseSumTTO warehouseSumTTO=new WarehouseSumTTO();
            warehouseSumTTO.setIntSum(0);
            warehouseSumTTO.setOutSum(0);
            warehouseSumTTO.setGoodsName(goodsTemp.getGoodsName());
            warehouseSumTTO.setGoodsId(goodsTemp.getGoodsId());
            warehouseSumTTOS.add(warehouseSumTTO);
        }
        for(WarehouseSumTTO warehouseSumTTO:warehouseSumTTOS){
            for(Warehouse item:list){

                String id = item.getGoodId();
                int type=item.getType();

                if (type==1&& id.equals(warehouseSumTTO.getGoodsId())){

                    warehouseSumTTO.setIntSum(warehouseSumTTO.getIntSum()+item.getAmount());

                }else if (type==2&&id.equals(warehouseSumTTO.getGoodsId())){
                    warehouseSumTTO.setOutSum(warehouseSumTTO.getOutSum()+item.getAmount());
                }
            }
        }

        WarehouseSumDTO warehouseSumDTO  =new WarehouseSumDTO();
        warehouseSumDTO.setWarehouseSum(warehouseSumTTOS);

        return R.success(warehouseSumDTO);
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