package spring.cache.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import spring.cache.demo.Bar;

/**
 * Class BarService
 *
 * @author wangoo
 * @since 2017-03-03 10:15
 */
@Service
@Slf4j
public class BarService {

    @Cacheable(value = "bar")
    public Bar getBar(long id) {
        log.info("create new bar:{}, will be cache in default cacheManager", id);
        Bar bar = new Bar();
        bar.setId(id);
        bar.setValue("test");
        return bar;
    }

    @Cacheable(value = "bar", cacheManager = "timeoutCacheManager")
    public Bar getExpiredBar(long id) {
        log.info(
                "create new expired bar:{}, will be cache in timeout cacheManager, expired after 1 min",
                id);
        Bar bar = new Bar();
        bar.setId(id);
        bar.setValue("test");
        return bar;
    }
}
