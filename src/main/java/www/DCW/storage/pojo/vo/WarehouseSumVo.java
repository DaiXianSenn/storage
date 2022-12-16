package www.DCW.storage.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: JhonDai
 * Date: 2022/12/14/17:06
 * Version: 1.0
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseSumVo {


    private String StartTime;  //开始日期

    private String EndTime; //结束日期

}