package test;

import dssc.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class AddNumbersTest {

    @Test
    void emptyString() { assertThat(StringCalculator.add(""), is(0)); }

    @Test
    void oneNumber() { assertThat(StringCalculator.add("1"), is(1)); }

    @Test
    void twoNumbers() { assertThat(StringCalculator.add("1,2"), is(3)); }

    @Test
    void manyNumbers() { assertThat(StringCalculator.add("1,2,3,4,5"), is(15)); }

    @Test
    void newline() { assertThat(StringCalculator.add("1,2\n3,4\n1,1"), is (12));}

    @Test
    void newDelimiter() { assertThat(StringCalculator.add("//[;]\n1;2;3;4;1;1"), is (12));}

    @Test
    void negativesNumber() throws Exception {assertThat(StringCalculator.add("-1,5,-5,5,-7"), is ("Negatives not allowed"));}

    @Test
    void numbersBiggerThan1000() { assertThat(StringCalculator.add("1,2,3,1100,1700,1665"), is(6)); }

    @Test
    void BigDelimiter () {assertThat(StringCalculator.add("//[:::]\n1:::2:::3"), is (6));}
}
