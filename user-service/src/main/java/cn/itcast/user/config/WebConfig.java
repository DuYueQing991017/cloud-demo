package cn.itcast.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 杜先森
 * @date 2022/8/23 + 15:11
 * @show    java配置类 作用:(注册拦截器)
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //生成一个拦截器,使拦截器生效
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/user/**");
    }
}
