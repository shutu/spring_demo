/**
 * @created 2014年11月2日 上午9:32:06
 */
package spring.demo.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author gelnyang
 * @created 2014年11月2日 上午9:32:06
 * @version 1.0
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ApplicationInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationInitializer.class, args);
    }
}
