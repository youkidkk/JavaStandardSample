package java8.sample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("javadoc")
public class LambdaSample {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("text1", "text2", "text3");
        stringList.forEach(s -> System.out.println(s));
        stringList.forEach(System.out::println);

        @SuppressWarnings("serial")
        Map<String, String> map = new HashMap<String, String>() {
            {
                this.put("foo", "fooVal");
                this.put("bar", "barVal");
            }
        };
        map.forEach((key, value) -> {
            System.out.println("key: " + key + " value: " + value);
        });

    }

}
