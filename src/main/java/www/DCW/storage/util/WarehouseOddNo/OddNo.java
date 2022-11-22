package www.DCW.storage.util.WarehouseOddNo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Author: JhonDai
 * Date: 2022/11/18/16:14
 * Version: 1.0
 * Description:
 */
public class OddNo {


    public static String getWarehouseOddNo(){

        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyyMMddhhmmss");




        return dateFormat.format(calendar.getTime());
    }
}
