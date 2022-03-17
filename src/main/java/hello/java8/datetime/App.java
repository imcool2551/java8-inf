package hello.java8.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;

public class App {

    public static void main(String[] args) {
        // 1. Instant - 기계용 시간 표시(epoch time)
        Instant instant = Instant.now();
        System.out.println(instant); // 기준시 UTC, GMT

        // 2. LocalDateTime, ZonedDateTime - 사람용 시간 표시
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime birthday =
                LocalDateTime.of(1996, 10, 16, 0, 0, 0);

        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        // 3. 상호 변환
        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        zonedDateTime.toInstant();

        // 4. 기간 비교 - Period(사람용), Duration(기계용)
        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthDay = LocalDate.of(2022, 10, 16);
        Period period = Period.between(today, thisYearBirthDay);
        System.out.println(period.getMonths());

        Period until = today.until(thisYearBirthDay);
        System.out.println(until.get(ChronoUnit.DAYS));

        Instant now2 = Instant.now();
        Instant plus = now2.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now2, plus);
        System.out.println(between.getSeconds());

        // 5. 포맷팅, 파싱 - DateTimeFormatter
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(formatter.format(dateTime));

        LocalDate parsed = LocalDate.parse("07/15/1982", formatter);
        System.out.println(parsed);

        // 6. ZoneId(자바8) <-> TimeZone(레거시)
        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);
    }
}
