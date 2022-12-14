package www.DCW.storage.filter;

/**
 * @Auther: zhaoss
 * @Date: 2022/8/15 - 08 - 15 - 19:37
 * @Description: com.itheima.reggie.filter
 * @version: 1.0
 */

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;
import www.DCW.storage.common.BaseContext;
import www.DCW.storage.common.R;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户是否已经完成登录 过滤器
 * 要在应用那边增加@ServletComponentScan//扫描WebFilter部件
 */
@Slf4j
//@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    //路径匹配器，支持通配符*
    public static final AntPathMatcher PATH_MATCHER =new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;

        //1、获取本次请求的URI
        String requestURI=request.getRequestURI();
        log.info("拦截到请求:{}",requestURI);//{}相当于占位符

        //定义不需要处理的请求路径
        String[] urls =new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/common/**"
        };

        //2、判断请求是否合理
        boolean check =check(urls,requestURI);
        //3、如果不需要处理，则直接放行
        if(check){
            log.info("本次请求{}不需要处理",requestURI);
            filterChain.doFilter(request,response);
            return;
        }
        //4、判断登录状态，如果已登录，则直接放行
        if(request.getSession().getAttribute("employee")!=null){
            log.info("用户已登录，用户id为：{}",request.getSession().getAttribute("employee"));

            Long employeeId = (Long)request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(employeeId);
            filterChain.doFilter(request,response);
            return;
        }
        //5、如果未登录 则返回未登录结果
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        log.info("用户未登录，跳转至登录界面");

    }

    /**
     * 路径匹配，检查是否需要放行
     * @param urls
     * @param requestURI
     * @return
     */
    public boolean check(String[] urls,String requestURI){
        for (String url : urls) {
            //使用PATH_MATCHER路径匹配器
            boolean match = PATH_MATCHER.match(url, requestURI);
            if(match){
                return true;
            }
        }
        return false;
    }
}
