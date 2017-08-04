package spring.cloud.stream.message.demo.dynamic;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import lombok.extern.slf4j.Slf4j;

import static org.springframework.messaging.MessageHeaders.CONTENT_TYPE;

/**
 * Class SampleSource
 *
 * @author wangoo
 * @since 2017-02-17 17:25
 */
//@EnableBinding(DynamicSource1.Dync1Source.class)
@Slf4j
public class DynamicSource1 {

    //@Bean
    //@InboundChannelAdapter(value = Dync1Source.channel, poller = @Poller(fixedDelay = "20000", maxMessagesPerPoll = "1"))
    public MessageSource<String> timerPublish() {
        return new MessageSource<String>() {
            public Message<String> receive() {
                String value = "dynamic 1:" + System.currentTimeMillis();
                log.info("[SOURCE][dynamic1]:" + value);
                return MessageBuilder.withPayload(value).setHeader(CONTENT_TYPE, "text/plain")
                        .build();
            }
        };
    }

    public interface Dync1Source {
        String channel = "dynamic-1";

        @Output(channel)
        MessageChannel source();
    }
}