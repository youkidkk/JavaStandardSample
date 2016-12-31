package java8.sample;

import java.util.Optional;

@SuppressWarnings("javadoc")
public class OptionalSample {

    public static void main(String[] args) {
        // Nullではない場合
        Optional<String> os = Optional.ofNullable("Not Null");
        os.ifPresent(s -> System.out.println(s)); // "Not Null"を出力
        System.out.println(os.orElse("デフォルト")); // "Not Null"を出力

        // Nullの場合
        os = Optional.ofNullable(null);
        os.ifPresent(s -> System.out.println(s)); // 出力なし
        System.out.println(os.orElse("デフォルト")); // "デフォルト"を出力

        // Emptyの場合
        os = Optional.empty();
        os.ifPresent(s -> System.out.println(s)); // 出力なし
        System.out.println(os.orElse("デフォルト")); // "デフォルト"を出力
    }

}
