package me.kwon.dateAndTime;

import javax.xml.datatype.Duration;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        System.out.println(date);
        long time = date.getTime(); //EPOCK : 기계용시간, 1970년 1월1일후로부터의 ms
        System.out.println(time);

        Thread.sleep(1000 * 3);
        Date after3Seconds = new Date();
        System.out.println(after3Seconds);
        after3Seconds.setTime(time); //3초 이전으로 돌아감 mutable한 성격
        System.out.println(after3Seconds);

        GregorianCalendar kwonBitthDay = new GregorianCalendar(1993, Calendar.DECEMBER,/*12*/ 28);
        //월에 12를 적으면 11월이됨. 그래서 enum을 사용해야함. type safeful
        System.out.println(kwonBitthDay.getTime());




    }
}
