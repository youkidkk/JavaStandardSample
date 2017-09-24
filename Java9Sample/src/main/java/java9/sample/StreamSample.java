package java9.sample;

import com.sun.tools.javac.util.List;

/**
 * Stream サンプル。
 */
@SuppressWarnings("javadoc")
public class StreamSample {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // takeWhile 条件に合致するもののみ
        list.stream().takeWhile(i -> i < 5).forEach(System.out::println);

        // dropWhile 条件に合致するものを除外
        list.stream().dropWhile(i -> i < 3).forEach(System.out::println);
    }

}
