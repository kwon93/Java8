package me.kwon.interfaceAndLambda;

public class LambdaBasicExample {
    public static void main(String[] args) {

        RunSomthing runSomthing = () -> System.out.println("뭐라도 좀 해라"); // 람다식
        //람다형태의 함수형 인터페이스를 표현하는 방법

        RunSomthing runSomthing2 = new RunSomthing() {
            //익명 내부 클래스
            @Override
            public void doIt() {
                //한줄일 경우에만 람다식을 사용할 수 있다.
                System.out.println("한줄");
                System.out.println("두줄");
            }
        };

        runSomthing.doIt();


        ReturnInt returnInt = (num) -> num + 10;
        //pure function은 함수밖의 있는 값을 참조하거나 변경하려하면 안됨. 함수 내부의 파리미터 혹은 함수내부에 가지고있는 값만을 이용
        int returnIntMethod = returnInt.returnIntMethod(10);
        System.out.println(returnIntMethod);




    }
}
