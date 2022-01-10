package MiconautKafkaRabbit.ultiliities.calculator;

public class Calculator {
    public static double calculate(double a, double b, String op){
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return  a - b;

            case "x":
                return  a * b;

            case ":":
                return  a / b;
        }
        return 0;
    }

}
