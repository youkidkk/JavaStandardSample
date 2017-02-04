package java8.sample;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * メソッド参照 サンプル
 */
@SuppressWarnings("javadoc")
public class MethodReferenceSample {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("foo", "bar", "baz");

        // List#forEach の引数の型 Consumer は戻り値なしで引数１個
        // System.out#println も同様のため、メソッド参照で代入できる
        list.forEach(System.out::println);
    }

}
