package spring.cloud.stream.message.demo;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.SubscribableChannel;

import lombok.extern.slf4j.Slf4j;

/**
 * Class SampleSink
 *
 * @author wangoo
 * @since 2017-02-17 17:22
 */
@EnableBinding(SampleSink.Sink.class)
@Slf4j
public class SampleSink {

    @StreamListener(Sink.SAMPLE)
    public void receive(Foo fooMessage) {
        log.info("[  SINK][channel]:" + fooMessage.getValue() + " , " + fooMessage.getClass());
    }

    public interface Sink {
        String SAMPLE = "sample-sink";

        @Input(SAMPLE)
        SubscribableChannel sampleSink();
    }
}
