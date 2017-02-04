package java8.sample;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Supplier;

/**
 * メソッド参照 サンプル
 */
@SuppressWarnings("javadoc")
public class MethodReferenceSample {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("foo", "bar", "baz");

        // List#forEach の引数の型 Consumer は戻り値なしで引数１個
        // System.out#print も同様のため、メソッド参照で代入できる
        list.forEach(System.out::print); // -> foobarbaz

        System.out.println();

        // List#size は戻り値 int で引数なしのため Supplier に代入できる
        Supplier<Integer> supplier = list::size;
        System.out.println(supplier.get()); // -> 3
    }

}
