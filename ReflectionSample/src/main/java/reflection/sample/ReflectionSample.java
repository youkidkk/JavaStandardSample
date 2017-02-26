package reflection.sample;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

@SuppressWarnings("javadoc")
@RequiredArgsConstructor
public class ReflectionSample {

    @Getter
    private final String field;

    @SuppressWarnings("unused")
    private String method(String string, int i) {
        return "Argument is " + string + ", " + i;
    }

    public static void main(String[] args) throws Exception {
        ReflectionSample sample = new ReflectionSample("Field value");

        // フィールドオブジェクトを取得
        Field field = ReflectionSample.class.getDeclaredField("field");
        // フィールドのタイプ（型）を取得
        System.out.println(field.getType());
        // フィールドの名前を取得
        System.out.println(field.getName());

        // privateフィールドへのアクセスを可能にする
        field.setAccessible(true);
        // オブジェクトを指定して、フィールドの値を取得
        System.out.println(field.get(sample));

        // メソッドオブジェクトを取得
        Method method = ReflectionSample.class.getDeclaredMethod("method", String.class, int.class);
        // メソッドの返却値の型を取得
        System.out.println(method.getReturnType());
        // メソッドの引数の型を取得
        System.out.println(String.join(", ",
                Arrays.asList(method.getParameterTypes()).stream()
                        .map(c -> c.getName())
                        .collect(Collectors.toList())));

        // privateメソッドへのアクセスを可能にする
        method.setAccessible(true);
        // オブジェクトを指定して、メソッドを実行
        System.out.println(method.invoke(sample, "test", 123));
    }

}
