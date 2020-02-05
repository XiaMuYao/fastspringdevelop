package top.xiamuyao.fastspringdevelop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
@ServletComponentScan
@EnableScheduling
@MapperScan("top.xiamuyao.fastspringdevelop.api.mapper")
public class FastspringdevelopApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastspringdevelopApplication.class, args);
    }
}
