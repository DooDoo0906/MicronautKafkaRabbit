package MiconautKafkaRabbit.kafka.consumer;

import MiconautKafkaRabbit.ultiliities.calculator.Calculator;
import MiconautKafkaRabbit.ultiliities.validation.Validation;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.vertx.core.json.JsonObject;


@KafkaListener(offsetReset = OffsetReset.EARLIEST)
public class Consumer {
    @Topic("my-calculator")
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
