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
            return splitString(numbers, alternativeRegex);
        }
        else{
            return splitString(numbers, regex);
        }
    }
    private static int splitString (String numbers, String regex){
        Pattern pattern = Pattern.compile(regex);
        String[] tokens;
        if(regex.equals("(,|\\R)")){
            tokens = pattern.split(numbers);
        }
        else{
            tokens = pattern.split(numbers.substring(4));
        }
        int somma=0;
        for (String token : tokens) {
            if(!token.equals("")) {
                somma = somma + Integer.parseInt(token);
            }
        }
        return somma;
    }
}
