package me.kwon;

@FunctionalInterface //이 애노테이션으로 함수형 인터페이스 검증가능
public interface RunSomthing {

    //추상메서드가 하나만 있다면 함수형 인터페이스
    void doIt();

    static void PrintName(){
        System.out.println("Kwon");
    }
    //스태틱 메서드를 정의할 수 있다.

    //디폴트 메서드를 정의할 수 있다.

    default void printAge(){
        System.out.println("29");
    }

    //이렇게 다른 형태의 메서드가 있더라도 추상 메서드가 한개라면 함수형 인터페이스다.

//    void doIt2(); 2개가 있다면 아니다
}
