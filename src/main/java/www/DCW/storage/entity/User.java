package www.DCW.storage.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Author: JhonDai
 * Date: 2022/10/24/22:19
 * Version: 1.0
 * Description:
 */
@ApiModel("用户实体")
@Data
@TableName("软工2001_18_人员表")
public class User {

	@ApiModelProperty("人员代码")
	//@TableField(value = "人员代码")待测试
	@TableId(value = "人员代码")
	private String userId; //用户id

	@ApiModelProperty("密码")
	@TableField(value = "密码")
	private String password;  //密码

	@ApiModelProperty("姓名")
	@TableField(value = "姓名")
	private String name;  //姓名

	@ApiModelProperty("账号")
	@TableField(value = "账号")
	private String username;

	@ApiModelProperty("性别")
	@TableField(value = "性别")
	private String gender;   //性别

	@ApiModelProperty("出生日期")
	@TableField(value = "出生日期")
	private String birthday;  //出生日期

	@ApiModelProperty("身份证号")
	@TableField(value = "身份证号")
	private String ID_number;  //身份证号

	@ApiModelProperty("籍贯")
	@TableField(value = "籍贯")
	private String native_place;  //籍贯

	@ApiModelProperty("地址")
	@TableField(value = "地址")
	private String address;  //家庭住址

	@ApiModelProperty("联系电话")
	@TableField(value = "联系电话")
	private String phone;   //联系电话

	@ApiModelProperty("备注")
	@TableField(value = "备注")
	private String remarks; //备注

}
