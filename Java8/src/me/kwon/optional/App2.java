package me.kwon.optional;

import me.kwon.streamAPI.OnlineClass;

import java.util.ArrayList;
import java.util.Optional;

public class App2 {
    public static void main(String[] args) {

        //Optional 익숙해지기
        ArrayList<OnlineClass2> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass2(1,"spring boot",true));
        springClasses.add(new OnlineClass2(2,"rest api development",true));

        Optional<OnlineClass2> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                //onlineClass의 이름이 "spring"으로 시작하는것은 있을수도 없을수도있기에 Optional type이 된다.
                .findFirst();

        boolean present1 = spring.isPresent(); //존재한다면 true
        boolean present2 = spring.isEmpty(); //존재하지 않는다면 true
        System.out.println("present1 = " + present1);
        System.out.println("present2 = " + present2);

        OnlineClass2 onlineClass2 = spring.get();
        System.out.println(onlineClass2.getTitle());

        Optional<OnlineClass2> jpa = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();
//
//        OnlineClass2 jpaClass = jpa.get(); //Optional 안에  null인 경우
//        System.out.println(jpaClass.getTitle()); NoSuchElementException 이 발생한다.


//        OnlineClass2 jpaOrElseClass = jpa.orElse(createNewClass()); 만약 없다면 새로운 무언가를 리턴하라
//        System.out.println(jpaOrElseClass.getTitle());  만들어져서 출력됨.

        OnlineClass2 jpaOrElseGetClass = jpa.orElseGet(() -> createNewClass()); //만약 없다면 새로운 무언가를 ~~를 하라
        System.out.println(jpaOrElseGetClass.getTitle());

//        OnlineClass2 elseThrow = jpa.orElseThrow(IllegalAccessError::new); 만약 없다면 예외를 던져라

        Optional<OnlineClass2> filterOptional = spring.filter(oc -> oc.getId() > 10); // 옵셔널에 필터걸기
        System.out.println("filterOptional = " + filterOptional);
        System.out.println(filterOptional.isPresent());
         


    }

    private static OnlineClass2 createNewClass() {
        System.out.println("create New Class");
        return new OnlineClass2(10,"new class",false);
    }
}
