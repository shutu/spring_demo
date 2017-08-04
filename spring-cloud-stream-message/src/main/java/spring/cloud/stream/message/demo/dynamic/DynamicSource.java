package spring.cloud.stream.message.demo.dynamic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Class SampleSource
 *
 * @author wangoo
 * @since 2017-02-17 17:25
 */
@Service
public class DynamicSource {

    @Autowired
    private DynamicDestinationPublisher publisher;

    int seq = 0;

    @Scheduled(initialDelay = 5000, fixedDelay = 5000)
    public void publish() {
        String destination = dynamicDestination();
        publisher.publishMessage(destination, null, "current seq is " + seq);
    }

    private String dynamicDestination() {
        return "dynamic-" + ((seq++) % 2 + 1);
    }

}