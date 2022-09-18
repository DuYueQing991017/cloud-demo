package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 杜先森
 * @date 2022/8/26 + 15:13
 * @show    读取配置,生成bean使用,实现自动刷新
 */
@Component          //注册为spring的一个bean
@Data               //get set方法
@ConfigurationProperties(prefix = "pattern")        //读取配置文件前缀
public class PatternProperties {
    private String dataformat;
}
