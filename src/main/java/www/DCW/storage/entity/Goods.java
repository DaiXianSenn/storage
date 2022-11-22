package www.DCW.storage.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Author: JhonDai
 * Date: 2022/10/24/22:19
 * Version: 1.0
 * Description:
 */
@Data
@TableName("软工2001_18_物料表")
public class Goods {


	@TableId(value = "物料代码")
	private String goodsId;   //物料代码

	@TableField(value = "物料名称")
	private String goodsName; //物料名称

	@TableField(value = "规格型号")
	private String type;	  //规格型号

	@TableField(value = "计量单位")
	private String goodsUnit; //计量单位

	@TableField(value = "库存数量")
	private int amount;		  //库存数量

	@TableField(value = "备注")
	private String remarks;   //备注

}
