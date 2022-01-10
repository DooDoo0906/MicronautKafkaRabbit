package MiconautKafkaRabbit.rabbitmq.producer;

import io.micronaut.context.annotation.Bean;
import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;
import io.micronaut.scheduling.annotation.Async;
import io.vertx.core.json.JsonObject;
import jakarta.inject.Singleton;

@RabbitClient
@Singleton
@Bean

public interface Client {

    @Binding("demoRabbiMQ")
    @Async
    void send(JsonObject data);
}