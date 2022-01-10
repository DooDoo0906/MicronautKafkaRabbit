package MiconautKafkaRabbit;

import MiconautKafkaRabbit.kafka.producer.Producer;
import MiconautKafkaRabbit.rabbitmq.producer.Client;
import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;
import io.vertx.core.json.JsonObject;

public class Application {

    public static void main(String[] args) {
        Client productClient;
        Producer producer;
        JsonObject message= new JsonObject();
        message.put("a",9*10);
        message.put("b",10);
        message.put("ope",":");
        ApplicationContext context=Micronaut.run(Application.class, args);
        productClient = context.getBean(Client.class);
        producer=context.getBean(Producer.class);
        productClient.send(message);
        producer.sendProduct(message);
    }
}
