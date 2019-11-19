package dssc;

public class StringCalculator {

    public static int add(String numbers) {
        if(numbers.isEmpty()) {
            return 0;
        }
        else if(numbers.contains(",")){
            String[] tokens = numbers.split(",");
            int somma=0;
            for (String token : tokens) {
                somma = somma + Integer.parseInt(token);
            }
            return somma;
        }
        else{
            return Integer.parseInt(numbers);
        }
        
    }
}
