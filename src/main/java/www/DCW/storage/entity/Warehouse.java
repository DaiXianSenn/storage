package www.DCW.storage.entity;


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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Warehouse {

	private String id;  //单号

	private int times;  //次数(同单号多条记录)

	private int type; //类型(1：入库 2：出库)

	private String goodId;  //物料代码

	private String userId; //操作人员代码

	private String date;  //日期

	private int amount;  //数量

	private String remarks; //备注

}
