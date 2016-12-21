/**
 * 
 */
package spring.demo.errorhandling.exception;

/**
 * @author wangoo
 * @since 2016-11-27 22:33 
 *
 */
public class UnconfigException extends Exception {

    /**
     * 
     */
    public UnconfigException() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public UnconfigException(String message, Throwable cause, boolean enableSuppression,
                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     */
    public UnconfigException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     */
    public UnconfigException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param cause
     */
    public UnconfigException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    
}
