package java8.sample;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@SuppressWarnings("javadoc")
public class DateTimeSample {

    public static void main(String[] args) {
        // 現在時刻
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        // 日時を指定して作成
        localDateTime = LocalDateTime.of(2016, 9, 1, 12, 30, 45, 999999999);
        System.out.println(localDateTime);

        // 明日の15時（日時の加算）
        localDateTime = LocalDateTime.now()
                .plusDays(1) // １日後
                .withHour(15)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
        System.out.println(localDateTime);
        localDateTime = LocalDateTime.now()
                .plusDays(1)
                .truncatedTo(ChronoUnit.HOURS) // 分以降を切り捨て
                .withHour(15);
        System.out.println(localDateTime);

        // ISO日時フォーマッタを使用して作成
        localDateTime = LocalDateTime.parse("2016-09-15T10:30:00.000");
        System.out.println(localDateTime);

        // 日時フォーマッター
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        localDateTime = LocalDateTime.parse("2016/07/01 13:30:00", formatter);
        System.out.println(localDateTime.format(formatter));
    }

}
