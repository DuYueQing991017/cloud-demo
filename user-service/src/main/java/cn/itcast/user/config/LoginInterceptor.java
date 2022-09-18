package cn.itcast.user.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 杜先森
 * @date 2022/8/23 + 15:05
 * @show
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 重写
     * @param request       前端请求
     * @param response      返回对应信息
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //拦截逻辑,返回true/false
        System.out.println("进入访问Controller前的拦截!");
        return true;
    }
}
