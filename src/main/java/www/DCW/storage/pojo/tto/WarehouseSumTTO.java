package www.DCW.storage.pojo.tto;

import lombok.Data;

/**
 * Author: JhonDai
 * Date: 2022/12/14/17:25
 * Version: 1.0
 * Description:
 */
@Data
public class WarehouseSumTTO {

    private String goodsId;
    private String goodsName;

    private int intSum;//入库

    private int outSum;//出库

}
