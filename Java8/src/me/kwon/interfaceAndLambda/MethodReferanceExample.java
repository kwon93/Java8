package me.kwon.interfaceAndLambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReferanceExample {
    public static void main(String[] args) {
        Function<Integer, String> intToString = (i) -> "number";
        String tenToString = intToString.apply(10);

        System.out.println(tenToString);

        //MethodReferance
        UnaryOperator<String> hi = Greeting::hi; //Greeting이라는 클래스의 hi라는 스태틱 메서드를 사용하겠다.
        System.out.println(hi.apply("kwon"));

        //인스턴스 메서드를 사용해다된다면
        Greeting greeting = new Greeting(); // 인스턴스화 한 뒤
        UnaryOperator<String> hello = greeting::hello; // 메소드 레퍼런스
        System.out.println(hello.apply("kwon"));

        //생성자도 참조 가능
        Supplier<Greeting> newGreeting = Greeting::new;
        Greeting greeting1 = newGreeting.get(); // 객체 생성

        //입력값을 받는 생성자
        Function<String , Greeting > kwonGreeting
                = Greeting::new;

        Greeting kwon = kwonGreeting.apply("kwon");
        System.out.println("kwon.getName() = " + kwon.getName());

        String[] names = {"kwon", "dong", "hyoek"};
        Arrays.sort(names, String::compareToIgnoreCase);
        //static 메서드가 아니다. "kwon", "dong".. 등등 이라는 임의의 객체의 인스턴스 메서드를 참조하는것
        System.out.println(Arrays.toString(names));
    }
}
