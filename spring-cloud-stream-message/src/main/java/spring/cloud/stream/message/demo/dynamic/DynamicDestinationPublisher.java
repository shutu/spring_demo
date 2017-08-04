package spring.cloud.stream.message.demo.dynamic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binding.BinderAwareChannelResolver;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangoo@soundbus.cn
 * @since 2017-08-04 17:09
 */
@Slf4j
@Service
public class DynamicDestinationPublisher {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private BinderAwareChannelResolver resolver;

    public void publishMessage(String destination, Map<String, Object> headers, Object object) {
        Assert.notNull(destination, "destination should not be null!");
        Assert.notNull(object, "sending object should not be null!");
        if (headers == null) {
            headers = new HashMap<>();
        }
        if (!headers.containsKey(MessageHeaders.CONTENT_TYPE)) {
            headers.put(MessageHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        }
        String body = null;
        if (object instanceof String) {
            body = (String) object;
        } else {
            try {
                body = objectMapper.writeValueAsString(object);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        log.info("publish event [{}] : {}", destination, body);
        Message<?> message = MessageBuilder.createMessage(body, new MessageHeaders(headers));
        resolver.resolveDestination(destination).send(message);
    }
}
