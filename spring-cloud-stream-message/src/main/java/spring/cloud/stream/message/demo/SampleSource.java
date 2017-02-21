package spring.cloud.stream.message.demo;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import static org.springframework.messaging.MessageHeaders.CONTENT_TYPE;

/**
 * Class SampleSource
 *
 * @author wangoo
 * @since 2017-02-17 17:25
 */
@EnableBinding(SampleSource.Source.class)
public class SampleSource {

    @Bean
    @InboundChannelAdapter(value = Source.SAMPLE, poller = @Poller(fixedDelay = "20000", maxMessagesPerPoll = "1"))
    public MessageSource<String> timerSampleMessageSource() {
        return new MessageSource<String>() {
            public Message<String> receive() {
                String value = "{\"value\":\"hi\"}";
                System.out.println("[SOURCE][SAMPLE]:" + value);
                return MessageBuilder.withPayload(value).setHeader(CONTENT_TYPE, "application/json")
                        .build();
            }
        };
    }

    public interface Source {
        String SAMPLE = "sample-source";

        @Output(SAMPLE)
        MessageChannel sampleSource();
    }
}