package java8.sample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("javadoc")
public class StreamApiSample {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 4, 5, 3, 2, 6, 7);

        intList
                // Stream にして
                .stream()
                // 2で割り切れるものだけにフィルタリングして
                .filter(i -> i % 2 == 0)
                // ソートして
                .sorted()
                // List に変換して
                .collect(Collectors.toList())
                // System.out#println で出力する
                .forEach(System.out::println);
    }

}
