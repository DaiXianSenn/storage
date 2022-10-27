package www.DCW.storage.common;

/**
 * @Auther: zhaoss
 * @Date: 2022/8/16 - 08 - 16 - 22:04
 * @Description: com.itheima.reggie.common
 * @version: 1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException ex){
        log.error(ex.getMessage());
        if(ex.getMessage().contains("Duplicate entry")){
            String[] split=ex.getMessage().split(" "); //split的一种用法 通过分割来确定信息 例子：Duplicate entry 'zhangsan' for key 'employee.idx_username'
            String msg = split[2]+"已存在";
            return R.error(msg);
        }
        return  R.error("未知错误");

    }

    @ExceptionHandler(CustomException.class)
    public R<String> exceptionHandler(CustomException ex){
        log.error(ex.getMessage());

        return  R.error(ex.getMessage());

    }
}
