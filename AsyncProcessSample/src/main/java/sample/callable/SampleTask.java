package sample.callable;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Callable;

@SuppressWarnings("javadoc")
public class SampleTask implements Callable<String> {

    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter
            .ofPattern("HH:mm:ss.SSS");

    private static final MessageFormat MSG_PRINT = new MessageFormat(
            "Task{0} start : {1}, end : {2}");

    private static final MessageFormat MSG_RESULT = new MessageFormat(
            "Task{0} {1} millis");

    private int index;

    public SampleTask(int index) {
        this.index = index;
    }

    @Override
    public String call() throws Exception {
        LocalDateTime start = LocalDateTime.now();
        Thread.sleep(3000);
        LocalDateTime end = LocalDateTime.now();

        System.out.println(MSG_PRINT.format(new String[] {
                Integer.toString(this.index),
                start.format(DATETIME_FORMATTER),
                end.format(DATETIME_FORMATTER) }));

        return MSG_RESULT.format(new String[] {
                Integer.toString(this.index),
                Long.toString(ChronoUnit.MILLIS.between(start, end)) });
    }

}
