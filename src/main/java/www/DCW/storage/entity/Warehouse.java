package www.DCW.storage.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: JhonDai
 * Date: 2022/10/24/22:19
 * Version: 1.0
 * Description:
 */
@ApiModel("仓库表")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("软工2001_18_进出仓表")
public class Warehouse {

	@ApiModelProperty("单号")
	@TableId(value = "单号",type = IdType.INPUT)
	private String id;  //单号

	@ApiModelProperty("次数")
	@TableField(value = "次数")
	private int times;  //次数(同单号多条记录)

	@ApiModelProperty("类型(1：入库 2：出库)")
	@TableField(value = "类型")
	private int type; //类型(1：入库 2：出库)

	@ApiModelProperty("物料代码")
	@TableField(value = "物料代码")
	private String goodId;  //物料代码

	@ApiModelProperty("操作人员代码")
	@TableField(value = "操作人员代码")
	private String userId; //操作人员代码

	@ApiModelProperty("日期")
	@TableField(value = "日期")
	private String date;  //日期

	@ApiModelProperty("数量")
	@TableField(value = "数量")
	private int amount;  //数量

	@ApiModelProperty("备注")
	@TableField(value = "备注")
	private String remarks; //备注

}
