package sample.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SuppressWarnings("javadoc")
public class FutureSample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<Future<String>> results = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            results.add(executor.submit(new SampleTask(i)));
        }

        results.forEach(result -> {
            new Thread(() -> {
                try {
                    System.out.println(result.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        });

        executor.shutdown();
    }

}
