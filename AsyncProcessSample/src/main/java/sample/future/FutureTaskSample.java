package sample.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

@SuppressWarnings("javadoc")
public class FutureTaskSample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 100; i++) {
            SampleTask task = new SampleTask(i);

            FutureTask<String> futureTask = new FutureTask<String>(task) {
                @Override
                protected void done() {
                    try {
                        System.out.println(this.get());
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                }
            };

            executor.execute(futureTask);
        }
    }

}
