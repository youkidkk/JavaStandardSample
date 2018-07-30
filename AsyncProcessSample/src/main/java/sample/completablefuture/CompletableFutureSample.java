package sample.completablefuture;

import sample.callable.SampleTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@SuppressWarnings("javadoc")
public class CompletableFutureSample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<CompletableFuture<String>> taskList = new ArrayList<>();

        IntStream.rangeClosed(1, 100).forEach(i -> {
            taskList.add(CompletableFuture.supplyAsync(() -> {
                try {
                    return new SampleTask(i).call();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }, executor));
        });

        CompletableFuture<Void> cf = CompletableFuture
                .allOf(taskList.toArray(new CompletableFuture[taskList.size()]));

        cf.whenComplete((ret, ex) -> {
            taskList.forEach(f -> {
                try {
                    System.out.println(f.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
        });

        executor.shutdown();
    }

}
