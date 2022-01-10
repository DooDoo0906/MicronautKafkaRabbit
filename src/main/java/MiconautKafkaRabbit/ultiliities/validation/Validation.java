package MiconautKafkaRabbit.ultiliities.validation;

public class Validation {

    public static boolean canOperate(double a, double b, String ope){
        if(Validation.isOpe(ope) && Validation.isNumeric(String.valueOf(a)) &&
                Validation.isNumeric(String.valueOf(b))){
            return true;
        }
        return false;
    }
    public static boolean isOpe(String ope){
        if(!ope.equalsIgnoreCase("+") && !ope.equalsIgnoreCase("-") && !ope.equalsIgnoreCase("x")
                && !ope.equalsIgnoreCase(":")){
            System.out.println("Please enter the right operation (+, -, x, :)");
            return false;
        }
        return true;
    }
    public static boolean isNumeric(String strNum1) {
        if (strNum1 == null) {
            System.out.println("Please enter the right number");
            return false;
        }
        try {
            double d = Double.parseDouble(strNum1);

        } catch (NumberFormatException nfe) {
            System.out.println("Please enter the right number");
            return false;
        }
        return  true;
    }
}
