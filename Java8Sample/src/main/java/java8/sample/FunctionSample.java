package java8.sample;

import java.util.function.Function;

@SuppressWarnings("javadoc")
public class FunctionSample {

    private Function<String, Object> func;

    public FunctionSample(Function<String, Object> func) {
        this.func = func;
    }

    public void run(String s) {
        System.out.println(this.func.apply(s));
    }

    public static void main(String[] args) {
        Function<String, Object> func = string -> {
            return string + " " + string + " " + string;
        };
        new FunctionSample(func).run("test");
    }

}
