package www.DCW.storage.entity;

import lombok.Data;

/**
 * Author: JhonDai
 * Date: 2022/10/24/22:19
 * Version: 1.0
 * Description:
 */

@Data
public class Bill {

	private String goodsId;   //物料代码

	private String goodsName; //物料名称

	private String goodstype;	  //规格型号

	private String goodsUnit; //计量单位

	private int type;

	private int amount;
	

	
}
