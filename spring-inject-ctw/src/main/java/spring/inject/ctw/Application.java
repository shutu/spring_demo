/**
 * @created 2014年11月2日 上午9:32:06
 */
package spring.inject.ctw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

import spring.inject.ctw.entity.User;

/**
 * @author gelnyang
 * @created 2014年11月2日 上午9:32:06
 * @version 1.0
 */

@SpringBootApplication
@EnableSpringConfigured
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        new User().displayDependencies();
    }
}
