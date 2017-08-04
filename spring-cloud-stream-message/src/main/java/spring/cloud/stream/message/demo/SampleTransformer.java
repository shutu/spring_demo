package spring.cloud.stream.message.demo;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

import lombok.extern.slf4j.Slf4j;


/**
 * Class SampleTransformer
 *
 * @author wangoo
 * @since 2017-02-17 17:26
 */
@EnableBinding(Processor.class)
@Slf4j
public class SampleTransformer {

    private static final String TRANSFORMATION_VALUE = "HI";

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Bar receive(Bar barMessage) {
        log.info("[TRANSF][channel]:" + TRANSFORMATION_VALUE + " , " + barMessage.getClass());
        barMessage.setValue(TRANSFORMATION_VALUE);
        return barMessage;
    }
}