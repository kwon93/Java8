package me.kwon.dateAndTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class App2 {
    public static void main(String[] args) {
        //date() 익숙해지기
        Instant instant = Instant.now();
        System.out.println(instant); //UTC , GMT,(영국) 기준 시

        ZoneId zoneId = ZoneId.systemDefault(); //현재 local system의 zone
        ZonedDateTime zonedDateTime = instant.atZone(zoneId); //system의 zone을 기준으로 시간이 출력
        System.out.println(zonedDateTime);

        LocalDateTime now = LocalDateTime.now(); //현재 local시간
        System.out.println(now);

        //날짜 설정
        LocalDateTime birthDay = LocalDateTime.of(1993,Month.DECEMBER,28,4,30,0);
        System.out.println(birthDay);

        //특정 zone의 시간 보기
        ZonedDateTime nowInBerlin = ZonedDateTime.now(ZoneId.of("Europe/Berlin"));
        System.out.println(nowInBerlin);

        //기간을 표현하는 방법
        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthDay = LocalDate.of(2023,Month.DECEMBER,28);

        Period between = Period.between(today, thisYearBirthDay);
        System.out.println(between.getMonths());

        Period until = today.until(thisYearBirthDay);
        System.out.println(until);

        //기계용 시간 비교
        Instant nowInstant = Instant.now();
        Instant plus = nowInstant.plus(20, ChronoUnit.SECONDS);
        Duration duration = Duration.between(nowInstant, plus);
        System.out.println(duration.getSeconds());


        //Format
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter ddMMyyyy = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //날짜 출력 포맷 설정가능.
        System.out.println(localDateTime.format(ddMMyyyy));

        //parsing
        LocalDate parse = LocalDate.parse("28/12/1993", ddMMyyyy);
        System.out.println("parse = " + parse);

        //구 API와 호환
        Date date = new Date();
        Instant instant2 = date.toInstant();
        Date date2 = Date.from(instant);

        ZoneId zoneId2 = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId2);
    }
}
