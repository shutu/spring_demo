/**
 * @created 2014年11月2日 上午9:32:06
 */
package spring.demo.cust.exception.resolver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

import spring.demo.cust.exception.resolver.exception.CustExceptionReslover;

/**
 * @author gelnyang
 * @version 1.0
 * @created 2014年11月2日 上午9:32:06
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableWebMvc
public class CustExceptionResolverApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustExceptionResolverApplication.class, args);
    }
}


@Configuration
class ExceptionHandleConfig extends WebMvcConfigurationSupport {

    @Override
    protected void extendHandlerExceptionResolvers(
            List<HandlerExceptionResolver> exceptionResolvers) {
        super.extendHandlerExceptionResolvers(exceptionResolvers);

        exceptionResolvers.add(0, new CustExceptionReslover());
    }
}