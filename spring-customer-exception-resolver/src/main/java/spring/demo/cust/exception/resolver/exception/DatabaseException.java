/**
 * 
 */
package spring.demo.cust.exception.resolver.exception;

import org.springframework.http.HttpStatus;

import spring.demo.cust.exception.resolver.exception.annotation.ExceptionInfo;

/**
 * @author wangoo
 * @since 2016-11-27 20:41
 *
 */
@ExceptionInfo(status = HttpStatus.INTERNAL_SERVER_ERROR, code="E001", desc = "database error" )
public class DatabaseException extends Exception {

    /**
     * 
     */
    public DatabaseException() {
        super();
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public DatabaseException(String message, Throwable cause, boolean enableSuppression,
                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * @param message
     * @param cause
     */
    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public DatabaseException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public DatabaseException(Throwable cause) {
        super(cause);
    }

}
