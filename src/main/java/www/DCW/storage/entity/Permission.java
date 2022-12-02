package www.DCW.storage.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: JhonDai
 * Date: 2022/10/24/22:19
 * Version: 1.0
 * Description:
 */
@ApiModel("权限实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("软工2001_18_权限管理")
public class Permission {

	@TableId(value="人员代码")
	@ApiModelProperty("人员代码")
	private String userId; //人员代码

	@ApiModelProperty("人员档案管理")
	@TableField(value = "人员档案管理")
	private int PersonPermission; //人员档案管理

	@ApiModelProperty("物料档案管理")
	@TableField(value = "物料档案管理")
	private int GoodsPermission;  //物料档案管理

	@ApiModelProperty("进出仓管理")
	@TableField(value = "进出仓管理")
	private int WarehousePermission;   //进出仓管理

	@ApiModelProperty("管理权限")
	@TableField(value = "管理权限")
	private int ManagePermission; //管理权限

	@ApiModelProperty("统计打印")
	@TableField(value = "统计打印")
	private int PrintPermission;
}
