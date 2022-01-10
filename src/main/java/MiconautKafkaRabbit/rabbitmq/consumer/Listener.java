package MiconautKafkaRabbit.rabbitmq.consumer;

import MiconautKafkaRabbit.ultiliities.calculator.Calculator;
import MiconautKafkaRabbit.ultiliities.validation.Validation;
import io.micronaut.rabbitmq.annotation.Queue;
import io.micronaut.rabbitmq.annotation.RabbitListener;
import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RabbitListener
public class Listener {

    List<String> messageLengths = Collections.synchronizedList(new ArrayList<>());

    @Queue("demoRabbiMQ")
    public void receive(JsonObject message) {
        double a = message.getDouble("a");
        double b = message.getDouble("b");
        String ope = message.getString("ope");
        System.out.println("Value: ");
        System.out.println(message.encodePrettily());
        if (Validation.canOperate(a,b,ope)) {
            System.out.println("Result: " + Calculator.calculate(a, b, ope));
        }
    }



}