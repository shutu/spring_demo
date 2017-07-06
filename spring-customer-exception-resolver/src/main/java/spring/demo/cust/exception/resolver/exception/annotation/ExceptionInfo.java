package spring.demo.cust.exception.resolver.exception.annotation;

import org.springframework.http.HttpStatus;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangoo@soundbus.cn
 * @since 2017-07-02 10:51
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExceptionInfo {

    HttpStatus status();

    String code();

    String desc();

}
