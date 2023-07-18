package me.kwon.interfaceAndLambda;

import java.util.function.*;

public class FunctionBaiscExample2 {
    public static void main(String[] args) {

        Plus10 plus10 = new Plus10();
        Integer apply = plus10.apply(10);
        System.out.println(apply);

        Function<Integer, Integer> plusTwenty = (num) -> num  + 20; //java.util.function.Function 인터페이스 사용
        System.out.println(plusTwenty.apply(10));

        Function<Integer, Integer> multiply = (num) -> num * 2;
        System.out.println(multiply.apply(10));

        //위에 두 인터페이스를 조합해보자.

        Function<Integer, Integer> multiplyAndPlusTwenty
                = plusTwenty.compose(multiply);
        //compose: 입력값을 가지고 뒤에오는 함수를 먼저 적용함. 그리고 그 결과값을 plusTwenty의 입력값으로 사용 (고차함수의 성격)
        System.out.println(multiplyAndPlusTwenty.apply(2)); // 2 * 2 실행 후 20을 더함 > 24 출력

        plusTwenty.andThen(multiply);
        System.out.println(plusTwenty.andThen(multiply).apply(2));
        //andThen: 입력값을 가지고 뒤에오는 함수를 마지막에 적용함. 2 + 20 후에 2를 곱함 -> 44 출력

        Consumer<Integer> consumer = (i) -> System.out.println(i); //리턴 타입이 없는 인터페이스
        consumer.accept(1);

        Supplier<Integer> get10 = () -> 10; // 파라미터없이 무조건 10이라는 타입을 리턴하겠다.
        System.out.println(get10.get());

        Predicate<String> startsWithKwon = (str) -> str.startsWith("Kwon"); //입력값을 받아 존재 여부를 true, false를 반환
        boolean kwon = startsWithKwon.test("Kwon"); //true 출력
        System.out.println(kwon); //predicate 또한 조합이 가능함. and, or, not

        UnaryOperator<Integer> plus10A = (i) -> i + 10; //입력값과 리턴값이 같다면 사용가능한 인터페이스
        System.out.println(plus10A.apply(30));

    }
}
