package java9.sample;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * Immutableコレクション サンプル。
 */
public class ImmutableCollectionSample {

    /**
     * メインメソッド。
     *
     * @param args
     */
    public static void main(String[] args) {
        List.of("hoge", "fuga", "piyo").forEach(System.out::println);

        Map.of("1", "foo", "2", "bar", "3", "baz").forEach((k, v) -> {
            System.out.println(MessageFormat.format("Key : {0}, Value : {1}", k, v));
        });
    }

}
