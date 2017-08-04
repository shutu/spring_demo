package spring.cloud.stream.message.demo.dynamic;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.SubscribableChannel;

import lombok.extern.slf4j.Slf4j;

/**
 * Class SampleSink
 *
 * @author wangoo
 * @since 2017-02-17 17:22
 */
@EnableBinding(DynamicSink2.Dync2Sink.class)
@Slf4j
public class DynamicSink2 {

    @StreamListener(Dync2Sink.channel)
    public void receive(Message<?> message) {
        MessageHeaders headers = message.getHeaders();
        log.info("header:{}", headers);
        log.info("payload:{}", message.getPayload());
    }

    public interface Dync2Sink {
        String channel = "dynamic-2";

        @Input(channel)
        SubscribableChannel sink();
    }
}
