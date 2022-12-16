package www.DCW.storage.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: JhonDai
 * Date: 2022/12/14/16:45
 * Version: 1.0
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseTableVo {

    //前端传过来的应该是物料id 名称 我们做一下查询

    private String goodId;  //物料代码

    private String StartTime;  //开始日期

    private String EndTime; //结束日期

}
