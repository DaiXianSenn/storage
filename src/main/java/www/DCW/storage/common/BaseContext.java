package www.DCW.storage.common;

/**
 * ThreadLocal封装线程工具类
 * 通过同一线程（threadLocal）来获取当前用户id
 * threadLocal 是Thread的分支
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal=new ThreadLocal<>();

    /**
     * 设置id
     * @param id
     */
    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    /**
     * 获取id
     * @return
     */

    public static Long getCurrentId(){
        return threadLocal.get();
    }
}
