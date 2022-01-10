package MiconautKafkaRabbit.kafka.producer;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.context.annotation.Bean;
import io.micronaut.scheduling.annotation.Async;
import io.vertx.core.json.JsonObject;
import jakarta.inject.Singleton;

@KafkaClient
@Singleton
public interface Producer {
    @Topic("my-calculator")
    @Async
    void sendProduct( JsonObject name);

}
