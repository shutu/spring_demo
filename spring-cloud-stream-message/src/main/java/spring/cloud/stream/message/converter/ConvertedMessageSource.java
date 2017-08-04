package spring.cloud.stream.message.converter;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import lombok.extern.slf4j.Slf4j;

import static org.springframework.messaging.MessageHeaders.CONTENT_TYPE;

/**
 * @author wangoo
 * @since 2017-02-17 17:25
 */
@EnableBinding(ConvertedMessageSource.ConverterSource.class)
@Slf4j
public class ConvertedMessageSource {

    @Bean
    @InboundChannelAdapter(value = ConverterSource.CONVERTER_SOURCE, poller = @Poller(fixedDelay = "11000", maxMessagesPerPoll = "1"))
    public MessageSource<ProtobufMessage.DemoMessage> timerDemoMessageSource() {
        return new MessageSource<ProtobufMessage.DemoMessage>() {
            public Message<ProtobufMessage.DemoMessage> receive() {
                Long seqNo = System.currentTimeMillis();
                String content = "test message";
                log.info("[SOURCE][DEMO MESSAGE]:" + seqNo + " , " + content);
                ProtobufMessage.DemoMessage demoMessage =
                        ProtobufMessage.DemoMessage.newBuilder().setSeqNo(seqNo).setContent(content)
                                .setType(ProtobufMessage.DemoMessage.MessageType.NORMAL).build();
                return MessageBuilder.withPayload(demoMessage)
                        .setHeader(CONTENT_TYPE, DemoMessageConverter.DEMO_MESSAGE_MIME_TYPE)
                        .build();
            }
        };
    }

    public interface ConverterSource {
        String CONVERTER_SOURCE = "converter-source";

        @Output(CONVERTER_SOURCE)
        MessageChannel converterSource();
    }
}