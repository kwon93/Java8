package me.kwon.interfaceAndLambda;

import java.util.function.*;

public class LambdaBasicExample2 {
    public static void main(String[] args) {
        UnaryOperator<Integer> plus10 = integer -> 10 + integer;
        UnaryOperator<Integer> multiply = integer ->  2 * integer;
        Function<Integer, Integer> compose = plus10.compose(multiply);
        System.out.println(compose.apply(10));

        Supplier<Integer> get10 = () -> 10;
        System.out.println("get10 = " + get10.get());

        BinaryOperator<Integer> sum = (Integer a, Integer b) -> a + b; // 파라미터에 타입을 생략해도 된다. 컴파일러가 제네릭의 타입을 보고 추론하기때문에


        //변수 캡쳐
        LambdaBasicExample2 lb2 = new LambdaBasicExample2();
        lb2.run();
    }

    private void run(){
        int baseNum = 10; // 이 변수가 사실상 final이라면 final 키워드를 생략할 수 있다.
//        baseNum++; 사실상 final이기에 컴파일오류가 남.

        class LocalClass{
            void printBaseNum(){
                int baseNum = 11; //쉐도잉으로 11이 출력됨. 쉐도잉 : 이 변수가 위에 baseNum을 가림
                System.out.println(baseNum);
            }
        }

        IntConsumer printInt = i -> {
            //람다식에는 쉐도잉이 없다. 람다식의 스코프는 run()과 같다.  로컬클래스와 익명클래스의 차이점
            System.out.println(i + baseNum);
        };

        printInt.accept(10);
    }
}
