package java9.sample;

import com.sun.tools.javac.util.List;

/**
 * Stream サンプル。
 */
@SuppressWarnings("javadoc")
public class StreamSample {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // takeWhile 条件に合致する要素以前の要素のみとする
        list.stream().takeWhile(i -> i < 5).forEach(System.out::println);

        // dropWhile 条件に合致する要素以後の要素のみとする
        list.stream().dropWhile(i -> i < 3).forEach(System.out::println);
    }

}
