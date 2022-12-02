package www.DCW.storage.util.WarehouseOddNo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Author: JhonDai
 * Date: 2022/11/18/16:14
 * Version: 1.0
 * Description:
 */
@Slf4j
@Component
public class OddNo {

    static SecureRandom random =new SecureRandom();


    public static String getWarehouseOddNo(){
        //获取随机数

        int randomInt=random.nextInt(10000);
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyyMMddhhmmss");
        String format = "W"+dateFormat.format(calendar.getTime())+randomInt;
        log.info("正在生成仓库单号： {}",format);
        return format;
    }
    public static String getUserNo(){
        //获取随机数
        int randomInt=random.nextInt(10);
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyyMMddhhmmss");
        String format = "User"+dateFormat.format(calendar.getTime())+randomInt;
        log.info("正在生成用户UUID： {}",format);
        return format;
    }

    public static String getGoodsNo(){
        int randomInt=random.nextInt(100);
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyyMMddhhmmss");
        String format = "G_"+dateFormat.format(calendar.getTime())+randomInt;
        log.info("正在生成用户UUID： {}",format);
        return format;
    }
}
