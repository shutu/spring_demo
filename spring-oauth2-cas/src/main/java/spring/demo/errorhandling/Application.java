/**
 * @created 2014年11月2日 上午9:32:06
 */
package spring.demo.errorhandling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author gelnyang
 * @created 2014年11月2日 上午9:32:06
 * @version 1.0
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableWebMvc
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
