package www.DCW.storage.common;

/**
 * 自定义业务异常 疑问：为什么是RuntimeException 而不是其他类型异常
 */
public class CustomException extends RuntimeException{
    public CustomException(String message){
        super(message);
    }
}
