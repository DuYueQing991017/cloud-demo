package cn.itcast.user.web;

import cn.itcast.user.config.PatternProperties;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
//@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PatternProperties patternProperties;

    //读取配置文件设置字段
//    @Value("${pattern.dataformat}")
//    private String dataformat;

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }

    @GetMapping("/now")
    public String queryByNowDateTime(){
        //LocalDateTime.now()获取当前时间
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternProperties.getDataformat()));
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDate.now());
        System.out.println(now);
        return now;
    }


    public static void main(String[] args) {
        List<String> strList = new ArrayList<String>();
        strList.add("111");
        strList.add("222");
        strList.add("333");
        strList.set(2,"444");
        System.out.println(strList);

        String a = "111";
        String b = "111";
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }


}
