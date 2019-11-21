package dssc;

import java.util.regex.Pattern;

public class StringCalculator {

    private static final String regex = "(,|\\R)";

    public static int add(String numbers) {
        if(numbers.isEmpty()) {
            return 0;
        }
        else if(numbers.charAt(0)=='/'){
            String alternativeRegex = String.valueOf(numbers.charAt(2));
            Pattern pattern = Pattern.compile(alternativeRegex);
            String[] tokens = pattern.split(numbers.substring(4));
            int somma=0;
            for (String token : tokens) {
                if(!token.equals("")) {
                    somma = somma + Integer.parseInt(token);
                }
            }
            return somma;
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
