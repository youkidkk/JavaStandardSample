package java8.sample;

import java.util.Optional;

@SuppressWarnings("javadoc")
public class OptionalSample {

    public static void run(Optional<String> optional) {
        // Optional#isPresent
        // 値が null でない場合、true を返却
        // 値が null の場合、false を返却
        if (optional.isPresent()) {
            System.out.println("Optional に値が設定されている！！！");
        } else {
            System.out.println("Optional に値が設定されていない。。。");
        }

        // Optional#ifPresent
        // 値が null でない場合、引数のラムダ式が実行される
        // 値が null の場合、引数のラムダ式は実行されない
        optional.ifPresent(s -> System.out.println("Optional の値は「" + s + "」ですよ。"));

        // Optional#orElse
        // 値が null でない場合、その値が戻り値となる
        // 値が null の場合、引数の値が戻り値となる
        System.out.println(optional.orElse("Optional は空です。"));

        // Optional#orElseGet
        // 値が null でない場合、その値が戻り値となる
        // 値が null の場合、引数のラムダ式が実行されて、その戻り値が戻り値となる
        System.out.println("Optional#orElseGet " + optional.orElseGet(() -> {
            System.out.println("OrElseGet のラムダ式が実行されました。");
            return "Optional は空です。。。";
        }));

        // Optional#orElseThrow
        // 値が null でない場合、その値が戻り値となる
        // 値が null の場合、引数のラムダ式の戻り値の例外がスローされる
        try {
            System.out.println("Optional#orElseThrow " +
                    optional.orElseThrow(() -> new Exception()));
        } catch (Exception ex) {
            System.out.println("Optional が空のため、例外が投げられました。");
        }

        // Optional#map
        // 値が null でない場合、引数のラムダ式の戻り値を値とする Optional を返却する
        // 値が null の場合、空の Optional が返却される
        Optional<Integer> mappedOptional = optional.map(s -> s.length());
        mappedOptional.ifPresent(i -> System.out.println("Optional の length は " + i + "です。"));
    }

    public static void main(String[] args) {
        // null ではない場合
        System.out.println("★☆★ When not null ★☆★");
        run(Optional.of("null ではない Optional。"));

        System.out.println();

        // null の場合
        System.out.println("★☆★ When null ★☆★");
        run(Optional.ofNullable(null));
    }

}
