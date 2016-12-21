/**
 * 
 */
package spring.demo.errorhandling.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * @author wangoo
 * @since 2016-11-27 20:40
 *
 */
@Configuration
public class ExceptionHandleConfig {

    @Bean(name = "simpleMappingExceptionResolver")
    public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();

        Properties mappings = new Properties();
        mappings.setProperty("DatabaseException", "databaseError");
        mappings.setProperty("InvalidCreditCardException", "creditCardError");

        r.setExceptionMappings(mappings); // None by default
        r.setDefaultErrorView("error"); // No default
        r.setExceptionAttribute("ex"); // Default is "exception"
        r.setWarnLogCategory("error.logger"); // No default

        return r;
    }
}
