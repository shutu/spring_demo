/**
 * @created 2014年11月2日 上午9:32:06
 */
package spring.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author gelnyang
 * @version 1.0
 * @created 2014年11月2日 上午9:32:06
 */
@SpringBootApplication
@EnableCaching
public class RedisHAApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisHAApplication.class, args);
    }

//    @Bean
//    public RedisConnectionFactory jedisConnectionFactory() {
//        RedisSentinelConfiguration sentinelConfig =
//                new RedisSentinelConfiguration().master("redisha").sentinel("127.0.0.1", 16379)
//                        .sentinel("127.0.0.1", 16380);
//        return new JedisConnectionFactory(sentinelConfig);
//    }
}