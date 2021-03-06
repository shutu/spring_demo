package spring.cache.demo;

import java.io.Serializable;

/**
 * Class Bar
 *
 * @author wangoo
 * @since 2017-02-17 17:21
 */
public class Bar implements Serializable {
    private long id;
    private String value;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
