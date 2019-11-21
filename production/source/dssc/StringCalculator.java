package dssc;

import java.util.regex.Pattern;

public class StringCalculator {

    private static final String regex = "(,|\\R)";

    public static int add(String numbers) {
        if(numbers.isEmpty()) {
            return 0;
        }
        else{
            Pattern pattern = Pattern.compile(regex);
            String[] tokens = pattern.split(numbers);
            int somma=0;
            for (String token : tokens) {
                if(!token.equals("")) {
                    somma = somma + Integer.parseInt(token);
                }
            }
            return somma;
        }
    }
}
