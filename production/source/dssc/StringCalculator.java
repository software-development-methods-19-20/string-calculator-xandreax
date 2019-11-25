package dssc;

import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {

    private static final String regex = "(,|\\R)";

    public static int add(String numbers) {
            if (numbers.isEmpty()) {
                return 0;
            } else if (numbers.charAt(0) == '/') {
                String alternativeRegex = String.valueOf(numbers.charAt(2));
                return splitString(numbers, alternativeRegex);
            } else {
                return splitString(numbers, regex);
            }
    }

    private static int splitString (String numbers, String regex){
        Pattern pattern = Pattern.compile(regex);
        Stream<String> tokens;
        if(regex.equals("(,|\\R)")){
            tokens = Stream.of(pattern.split(numbers));
        }
        else{
            tokens = Stream.of(pattern.split(numbers.substring(4)));
        }
        int[] intTokens = tokens.filter(x-> !x.equals("")).mapToInt(Integer::parseInt).toArray();
        if(IntStream.of(intTokens).anyMatch(x -> x<0)){
            StringBuilder negatives = new StringBuilder();
            for (int intToken : intTokens) {
                if (intToken < 0)
                    negatives.append(Integer.toString(intToken)).append(" ");
            }
            throw new IllegalArgumentException("Negatives not allowed:"+negatives);
        }
        return IntStream.of(intTokens).filter(x -> x<1001).sum();
    }
}
