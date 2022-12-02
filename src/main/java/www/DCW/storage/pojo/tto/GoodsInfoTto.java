package www.DCW.storage.pojo.tto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Author: JhonDai
 * Date: 2022/11/26/14:43
 * Version: 1.0
 * Description: TTO TransferObject
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsInfoTto {
    @ApiModelProperty("数量")
    private int amount;  //数量

    @ApiModelProperty("物料代码")
    private String goodId;  //物料代码
}
