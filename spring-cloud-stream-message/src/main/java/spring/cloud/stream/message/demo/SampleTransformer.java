package spring.cloud.stream.message.demo;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;


/**
 * Class SampleTransformer
 *
 * @author wangoo
 * @since 2017-02-17 17:26
 */
@EnableBinding(Processor.class)
public class SampleTransformer {

    private static final String TRANSFORMATION_VALUE = "HI";

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Bar receive(Bar barMessage) {
        System.out.println(
                "[TRANSF][SAMPLE]:" + TRANSFORMATION_VALUE + " , " + barMessage.getClass());
        barMessage.setValue(TRANSFORMATION_VALUE);
        return barMessage;
    }
}