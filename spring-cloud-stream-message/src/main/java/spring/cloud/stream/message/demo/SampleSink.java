package spring.cloud.stream.message.demo;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.SubscribableChannel;

/**
 * Class SampleSink
 *
 * @author wangoo
 * @since 2017-02-17 17:22
 */
@EnableBinding(SampleSink.Sink.class)
public class SampleSink {

    @StreamListener(Sink.SAMPLE)
    public void receive(Foo fooMessage) {
        System.out.println(
                "[  SINK][SAMPLE]:" + fooMessage.getValue() + " , " + fooMessage.getClass());
    }

    public interface Sink {
        String SAMPLE = "sample-sink";

        @Input(SAMPLE)
        SubscribableChannel sampleSink();
    }
}
