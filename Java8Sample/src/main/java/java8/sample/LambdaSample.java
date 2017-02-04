package java8.sample;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * ラムダ式サンプル
 */
@SuppressWarnings("javadoc")
public class LambdaSample {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("text1", "text2", "text3");
        stringList.forEach(s -> System.out.println(s));
        stringList.forEach(System.out::println);

        Map<String, String> map = ImmutableMap.of(
                "foo", "fooVal", "bar", "barVal", "baz", "bazVal");
        map.forEach((key, value) -> {
            System.out.println("key: " + key + " value: " + value);
        });

        Function<Integer, String> func = i -> i + " + " + i + " = " + (i + i);
        System.out.println(func.apply(1));
        System.out.println(func.apply(3));
        System.out.println(func.apply(5));
    }

}
