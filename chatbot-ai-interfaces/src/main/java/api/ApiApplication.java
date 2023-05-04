package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author：CJF
 * @Project：chatbot-ai
 * @name：ApiApplication
 * @Date：2023/5/4 10:11
 * @description：启动入口
 */

@SpringBootApplication(scanBasePackages = "domain.zsxq")
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class,args);
    }
}
