package me.kwon.interfaceDefaultAndStatic;

public interface Foo {
    void printName();

    /**
    * @implSpec
    * 이 구현체는 getName()으로 가여온 문자열을 대문자로 바꿔 출력한다.
    * */
    // 메서드 선언뿐 아니라 구현체를 제공하는 방법
    default void printNameUpperCase(){ //해당 인터페이스를 구현한 클래스를 깨트리지 않고 새 기능을 추가할 수 있다.
        System.out.println(getName().toUpperCase()); // 구현가능.
    }
    /*
    * but 구현체가 모르게 추가된 기능으로 그만큼 리스크가 있음
    *       - 구현체에 따라 컴파일 에러가 발생할 수 있음
    *       - 반드시 문서화 할 것.
    *       - Object method는 재정의 할 수 없다.
    * */

    static void printAnything(){
        System.out.println("foo");
    }

    String getName();
}
