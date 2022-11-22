package www.DCW.storage.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: JhonDai
 * Date: 2022/11/18/14:35
 * Version: 1.0
 * Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WareahouseVo {


    //现在是开单子 出仓或者入仓 不需要单号 我们自己生成
    private String id;  //单号

    //？
    private int times;  //次数(同单号多条记录)

    //
    private int type; //类型(1：入库 2：出库)

    //前端传过来的应该是物料id 名称 我们做一下查询
    //private String goodId;  //物料代码
    private String goodName;

    //这个我们应该在那个拿到
    private String userId; //操作人员代码

    //解析一下日期
    private String date;  //日期

    private int amount;  //数量

    private String remarks; //备注

}
