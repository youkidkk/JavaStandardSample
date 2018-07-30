package sample.executorservice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings("javadoc")
public class ExecutorServiceSample {

    private static final DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("yyyy/MM/dd HH:mm:ss.SSS");

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Finish : " + LocalDateTime.now().format(formatter));
            });
            Thread.sleep(100);
        }

        executor.shutdown();
    }

}
