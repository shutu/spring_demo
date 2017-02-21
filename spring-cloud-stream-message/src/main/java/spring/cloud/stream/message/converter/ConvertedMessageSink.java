package spring.cloud.stream.message.converter;

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
@EnableBinding(ConvertedMessageSink.ConverterSink.class)
public class ConvertedMessageSink {

    // Sink application definition
    @StreamListener(ConverterSink.CONVERTER_SINK)
    public void receive(ProtobufMessage.DemoMessage demoMessage) {
        System.out.println("[  SINK][DEMO MESSAGE]:" + demoMessage.getSeqNo() + " , " + demoMessage
                .getContent());
    }

    public interface ConverterSink {
        String CONVERTER_SINK = "converter-sink";

        @Input(CONVERTER_SINK)
        SubscribableChannel converterSink();
    }
}
