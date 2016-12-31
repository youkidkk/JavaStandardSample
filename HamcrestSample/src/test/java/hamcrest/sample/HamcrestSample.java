package hamcrest.sample;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class HamcrestSample {

    @Test
    public void testIs() {
        assertThat("abc", is("abc"));
    }

    @Test
    public void testNot() {
        assertThat("abc", not("def"));
    }

    @Test
    public void testNullValue() {
        assertThat(null, nullValue());
        assertThat("", not(nullValue()));
    }

    @Test
    public void testNotNullValue() {
        assertThat("abc", notNullValue());
    }

    @Test
    public void testEqualTo() {
        assertThat("abc", equalTo("abc"));
    }

    @Test
    public void testSameInstance() {
        String s1 = "aaa";
        String s2 = "aaa";
        assertThat(s1, sameInstance(s2));

        String s3 = new String("aaa");
        assertThat(s1, not(sameInstance(s3)));
    }

    @Test
    public void testInstanceOf() {
        assertThat(123, instanceOf(Integer.class));
    }

    @Test
    public void testStartsWith() {
        assertThat("abcdef", startsWith("abc"));
    }

    @Test
    public void testEndsWith() {
        assertThat("abcdef", endsWith("def"));
    }

    @Test
    public void testContainsString() {
        assertThat("abcdef", containsString("bcd"));
    }

}
