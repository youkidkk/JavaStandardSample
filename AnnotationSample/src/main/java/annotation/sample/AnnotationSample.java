package annotation.sample;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("javadoc")
public class AnnotationSample {

    @Annotation
    @Getter
    public int field;

    public static void main(String[] args) throws Exception {
        // フィールドに設定されているアノテーションを取得
        List<java.lang.annotation.Annotation> annotations = Arrays
                .asList(AnnotationSample.class.getField("field")
                        .getAnnotations());
        System.out.println(
                annotations.stream().map(a -> a.toString()).collect(Collectors.toList()));
    }

}
