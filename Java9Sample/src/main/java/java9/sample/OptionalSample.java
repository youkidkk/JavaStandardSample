package java9.sample;

import java.util.List;
import java.util.Optional;

/**
 * Optional サンプル。
 */
@SuppressWarnings("javadoc")
public class OptionalSample {

    public static void main(String[] args) {
        List<Optional<String>> list = List.of(Optional.of("hoge"), Optional.empty(),
                Optional.of("fuga"));

        // ifPresentOrElse
        list.forEach(o -> {
            o.ifPresentOrElse(
                    System.out::println, // Not-Null時の処理
                    () -> {
                        System.out.println("Null!!!"); // Null時の処理
                    });
        });

        // flatMap
        list.stream()
                .flatMap(Optional::stream) // Nullを除外したStreamとなる
                .forEach(System.out::println);
    }

}
