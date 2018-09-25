package top.xiamuyao.fastspringdevelop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("top.xiamuyao.fastspringdevelop.api.mapper")
public class FastspringdevelopApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastspringdevelopApplication.class, args);
		System.out.println("接口文档地址: http://localhost:8181/swagger-ui.html");
	}
}
