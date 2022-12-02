package www.DCW.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import www.DCW.storage.common.R;
import www.DCW.storage.entity.Warehouse;

import www.DCW.storage.pojo.vo.WarehouseVoList;

import java.util.List;

/**
 * Author: JhonDai
 * Date: 2022/11/12/9:34
 * Version: 1.0
 * Description:
 */

public interface WarehouseService extends IService<Warehouse> {
    List<Warehouse> getAll();


//    R<String> inWarehouse(WareahouseVo wareahouseVo);

    R<String> saveWarehouse(Warehouse warehouse);

    R<String> saveWarehouseByList(WarehouseVoList warehouse);

}
