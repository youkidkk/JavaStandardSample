package basic.collection.iterator;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

@SuppressWarnings("javadoc")
public class DateTimeIterator implements Iterable<LocalDateTime>, Iterator<LocalDateTime> {

    private static final DateTimeFormatter FORMATTER = //
            DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");

    private LocalDateTime end;

    private Duration step;

    private LocalDateTime current;

    public DateTimeIterator(LocalDateTime start, LocalDateTime end, Duration step) {
        super();
        this.end = end;
        this.step = step;

        this.current = start;
    }

    @Override
    public Iterator<LocalDateTime> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        if (this.current.compareTo(this.end) < 0) {
            return true;
        }
        return false;
    }

    @Override
    public LocalDateTime next() {
        LocalDateTime result = this.current;
        this.current = this.current.plus(this.step);

        return result;
    }

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Now : " + now.format(FORMATTER));

        Iterable<LocalDateTime> iterator = new DateTimeIterator(
                now.withNano(0), now.plusMinutes(1), Duration.ofSeconds(7));
        for (LocalDateTime current : iterator) {
            System.out.println("      " + current.format(FORMATTER));
        }
    }

}
