package spring.cache.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

import javax.annotation.Resource;

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

    private static final String BAR_MAP = "bar_map";
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;

    public Bar getCustomerBar(long id) throws IOException {
        byte[] bytes = (byte[]) redisTemplate.opsForHash().get(BAR_MAP, id);
        if (bytes != null) {
            log.info("get bar {} from customer operation cache", id);
            Bar bar = objectMapper.readValue(bytes, Bar.class);
            return bar;
        } else {
            log.info("create new bar:{}, serialize it and cache the result in default cacheManager",
                    id);
            Bar bar = new Bar();
            bar.setId(id);
            bar.setValue("test");

            bytes = objectMapper.writeValueAsBytes(bar);
            redisTemplate.opsForHash().put(BAR_MAP, id, bytes);
            return bar;
        }
    }

}
