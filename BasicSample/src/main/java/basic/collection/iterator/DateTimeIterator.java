package basic.collection.iterator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

@SuppressWarnings("javadoc")
public class DateTimeIterator implements Iterable<LocalDateTime>, Iterator<LocalDateTime> {

    private static final DateTimeFormatter FORMATTER = //
            DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");

    private LocalDateTime end;

    private int stepSeconds;

    private LocalDateTime current;

    public DateTimeIterator(LocalDateTime start, LocalDateTime end, int stepSeconds) {
        super();
        this.end = end;
        this.stepSeconds = stepSeconds;

        current = start;
    }

    @Override
    public Iterator<LocalDateTime> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        if (current.compareTo(end) < 0) {
            return true;
        }
        return false;
    }

    @Override
    public LocalDateTime next() {
        LocalDateTime result = current;
        current = current.plusSeconds(stepSeconds);

        return result;
    }

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Now : " + now.format(FORMATTER));

        for (LocalDateTime current : new DateTimeIterator(now.withNano(0), now.plusMinutes(1), 7)) {
            System.out.println("      " + current.format(FORMATTER));
        }
    }

}
