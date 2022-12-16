package www.DCW.storage.pojo.dto;

import lombok.Data;
import www.DCW.storage.pojo.tto.WarehouseSumTTO;

import java.util.List;

/**
 * Author: JhonDai
 * Date: 2022/12/14/17:09
 * Version: 1.0
 * Description:
 */
@Data
public class WarehouseSumDTO {

    List<WarehouseSumTTO> warehouseSum;

}
