package spring.cloud.stream.message.converter;


import org.apache.commons.lang3.ArrayUtils;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.AbstractMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;

import lombok.extern.slf4j.Slf4j;

/**
 * Class DemoMessageConverter
 *
 * @author wangoo
 * @since 2017-02-20 17:51
 */
@Slf4j
@Component
public class DemoMessageConverter extends AbstractMessageConverter {
    public static final String DEMO_MESSAGE_MIME_TYPE = "application/x-spring-demo-message";

    public DemoMessageConverter() {
        super(MimeType.valueOf(DEMO_MESSAGE_MIME_TYPE));
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        return byte[].class == aClass || ProtobufMessage.DemoMessage.class.isAssignableFrom(aClass);
    }

    @Override
    protected Object convertFromInternal(Message<?> message, Class<?> targetClass,
            Object conversionHint) {
        try {
            Object payload = message.getPayload();
            if (payload instanceof ProtobufMessage.DemoMessage) {
                return payload;
            } else if (payload instanceof Byte[]) {
                return ProtobufMessage.DemoMessage
                        .parseFrom(ArrayUtils.toPrimitive((Byte[]) payload));
            } else {
                return payload;
            }
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return null;
    }

    @Override
    protected Object convertToInternal(Object payload, MessageHeaders headers,
            Object conversionHint) {
        try {
            if (payload instanceof ProtobufMessage.DemoMessage) {
                ProtobufMessage.DemoMessage msg = (ProtobufMessage.DemoMessage) payload;
                return ArrayUtils.toObject(msg.toByteArray());
            } else if (payload instanceof byte[]) {
                return payload;
            } else {
                return null;
            }
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return null;
    }
}
