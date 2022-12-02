package www.DCW.storage.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import www.DCW.storage.pojo.tto.GoodsInfoTto;

import java.util.List;

/**
 * Author: JhonDai
 * Date: 2022/11/26/14:24
 * Version: 1.0
 * Description:
 */
@ApiModel("仓库表")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseVoList {

    @ApiModelProperty("单号")
    private String id;  //单号

    @ApiModelProperty("次数")
    private int times;  //次数(同单号多条记录)

    @ApiModelProperty("类型(1：入库 2：出库)")
    private int type; //类型(1：入库 2：出库)


    @ApiModelProperty("物料<List>部分信息：")
    private List<GoodsInfoTto> goodsInfoTtoList;  //数量

    @ApiModelProperty("操作人员代码")
    private String userId; //操作人员代码

    @ApiModelProperty("日期")
    private String date;  //日期

    @ApiModelProperty("备注")
    private String remarks; //备注

}
