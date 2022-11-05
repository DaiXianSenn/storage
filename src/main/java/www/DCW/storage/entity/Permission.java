package www.DCW.storage.entity;


import lombok.Data;

/**
 * Author: JhonDai
 * Date: 2022/10/24/22:19
 * Version: 1.0
 * Description:
 */
@Data
public class Permission {

	private String userId; //人员代码

	private int useperson; //人员档案管理

	private int usegoods;  //物料档案管理

	private int usebill;   //进出仓管理

	private int usepermission; //管理权限

}
