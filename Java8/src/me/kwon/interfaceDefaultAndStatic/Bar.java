package me.kwon.interfaceDefaultAndStatic;

public interface Bar{

//    void printNameUpperCase(); // 디폴트 메서드를 상속해서 추상화 가능
    default void printNameUpperCase(){
        System.out.println("bar");
    }
}
