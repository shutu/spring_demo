package spring.demo.cust.exception.resolver.exception;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j;
import spring.demo.cust.exception.resolver.exception.annotation.ExceptionInfo;

/**
 * @author wangoo@soundbus.cn
 * @since 2017-07-02 10:48
 */
@Log4j
public class CustExceptionReslover implements HandlerExceptionResolver {

    private static final String DEFAULT_EXCEPTION_CODE = "E0000";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, Object o, Exception e) {

        ExceptionDescriptor descriptor = new ExceptionDescriptor();

        ExceptionInfo annotation =
                AnnotationUtils.findAnnotation(e.getClass(), ExceptionInfo.class);

        if (annotation != null) {
            descriptor.setCode(annotation.code());
            descriptor.setDesc(annotation.desc());
            descriptor.setMsg(e.getMessage());
            httpServletResponse.setStatus(annotation.status().value());
        } else {
            descriptor.setCode(DEFAULT_EXCEPTION_CODE);
            descriptor.setMsg(e.getMessage());
            httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

        try {
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            OutputStream outputStream = httpServletResponse.getOutputStream();
            objectMapper.writeValue(outputStream, descriptor);
            outputStream.flush();
            //return empty model and view to short circuit the iteration and to let
            //Spring know that we've rendered the view ourselves:
            return new ModelAndView();
        } catch (IOException ex) {
            log.warn("failed to response error message:" + ex.getMessage());
        }
        return null;
    }
}
