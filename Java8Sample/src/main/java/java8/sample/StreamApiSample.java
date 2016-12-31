package java8.sample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("javadoc")
public class StreamApiSample {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 5, 3);

        List<Integer> sortedList = intList.stream().sorted().collect(Collectors.toList());
        sortedList.forEach(i -> System.out.println(i));
    }

}
