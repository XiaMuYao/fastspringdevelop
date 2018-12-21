package top.xiamuyao.fastspringdevelop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@SpringBootApplication
@ServletComponentScan
@EnableScheduling
@MapperScan("top.xiamuyao.fastspringdevelop.api.mapper")
public class FastspringdevelopApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastspringdevelopApplication.class, args);
        System.out.println("接口文档地址: http://localhost:8383/swagger-ui.html");
    }
}
