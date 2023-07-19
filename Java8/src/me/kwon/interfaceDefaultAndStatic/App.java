package me.kwon.interfaceDefaultAndStatic;

public class App {
    public static void main(String[] args) {
        FooImpl kwon = new FooImpl("kwon");
        kwon.printNameUpperCase();
        System.out.println(kwon.getName());

        Foo.printAnything();
    }
}
