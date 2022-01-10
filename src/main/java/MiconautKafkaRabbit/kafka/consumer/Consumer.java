package MiconautKafkaRabbit.kafka.consumer;

import MiconautKafkaRabbit.ultiliities.calculator.Calculator;
import MiconautKafkaRabbit.ultiliities.validation.Validation;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.context.annotation.Bean;
import io.micronaut.scheduling.annotation.Async;
import io.vertx.core.json.JsonObject;
import jakarta.inject.Singleton;

@Singleton
@KafkaListener(offsetReset = OffsetReset.EARLIEST)
public class Consumer {
    @Topic("my-calculator")
    public void receive(JsonObject message) {

        double a = message.getDouble("a");
        double b = message.getDouble("b");
        String ope = message.getString("ope");

        if (Validation.canOperate(a,b,ope)) {
            System.out.println("Kafka Result: " + Calculator.calculate(a, b, ope));
        }
    }
}
