package MiconautKafkaRabbit.rabbitmq.producer;

import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;
import io.vertx.core.json.JsonObject;

@RabbitClient
public interface Client {

    @Binding("demoRabbiMQ")
    void send(JsonObject data);
}