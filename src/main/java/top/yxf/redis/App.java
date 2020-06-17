package top.yxf.redis;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// exclude= {DataSourceAutoConfiguration.class}
@SpringBootApplication
@MapperScan("top.yxf.redis.dao")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
