package me.kwon.streamAPI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App2 {
    public static void main(String[] args) {
        //Stream 익숙해지기
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1,"spring boot", true));
        springClasses.add(new OnlineClass(2,"spring data JPA", true));
        springClasses.add(new OnlineClass(3,"spring mvc", false));
        springClasses.add(new OnlineClass(4,"spring core", false));
        springClasses.add(new OnlineClass(5,"rest api development", false));

        System.out.println("spirng 으로 시작하는 수업 : ");
        //TODO
        springClasses.stream()
                .filter(s -> s.getTitle().startsWith("spring"))
                .forEach(oc -> System.out.println(oc.getTitle()));
        System.out.println();

        System.out.println("close 되지 않은 수업 : ");
        //TODO
        springClasses.stream()
                .filter(Predicate.not(OnlineClass::isClosed))
                .forEach(oc -> System.out.println(oc.getTitle()));
        System.out.println();

        System.out.println("수업 이름만 모아서 스트림 만들기 : ");
        //TODO
        springClasses.stream()
                .map(OnlineClass::getTitle)
                .forEach(System.out::println);
        System.out.println();


        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6,"The java, Test",true));
        javaClasses.add(new OnlineClass(7,"The java, Code manipulation",true));
        javaClasses.add(new OnlineClass(8,"The java, 8 to 11",false));

        List<List<OnlineClass>> kwonEvent = new ArrayList<>();
        kwonEvent.add(springClasses);
        kwonEvent.add(javaClasses);

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력 : ");
        //TODO
        kwonEvent.stream()
                .flatMap(Collection::stream)
                .forEach(oc -> System.out.println(oc.getId()));
        System.out.println();


        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만 : ");
        //TODO
        Stream.iterate(10,i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);
        System.out.println();


        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        //TODO
        boolean test = javaClasses.stream()
                .anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println(test);
        System.out.println();


        System.out.println("스프링 수업중에 제목에 spring이 들어간 제목만 모아서 List 만들기 : ");
        //TODO
        List<String> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().contains("spring"))
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());
        spring.forEach(System.out::println);


    }
}
