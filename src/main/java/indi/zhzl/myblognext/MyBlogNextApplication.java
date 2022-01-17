package indi.zhzl.myblognext;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("indi.zhzl.myblognext.dao")
public class MyBlogNextApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBlogNextApplication.class, args);
    }

}
