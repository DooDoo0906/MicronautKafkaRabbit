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
        System.out.println(context.getBean(Client.class));
        productClient = context.getBean(Client.class);
        productClient.send(message);
        producer=context.getBean(Producer.class);
        producer.sendProduct(message);
    }
}
