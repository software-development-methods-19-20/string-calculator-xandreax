package test;

import dssc.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class AddNumbersTest {

    @Test
    void emptyString() { assertThat(StringCalculator.add(""), is(0)); }

    @Test
    void oneNumber() {
        assertThat(StringCalculator.add("1"), is(1));
    }

    @Test
    void twoNumbers() { assertThat(StringCalculator.add("1,2"), is(3)); }

    @Test
    void manyNumbers() { assertThat(StringCalculator.add("1,2,3,4,5"), is(15)); }

    @Test
    void newline() { assertThat(StringCalculator.add("1,2\n3,4\n1,1"), is (12));}

    @Test
    void newDelimiter() { assertThat(StringCalculator.add("//;\n1;2;3;4;1;1"), is (12));}
}
