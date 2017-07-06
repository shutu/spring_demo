package spring.demo.cust.exception.resolver.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * @author wangoo@soundbus.cn
 * @since 2017-07-06 08:33
 */
@Data
public class ExceptionDescriptor {
    private String code;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String desc;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String msg;
}
