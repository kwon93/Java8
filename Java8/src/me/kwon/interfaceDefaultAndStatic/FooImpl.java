package me.kwon.interfaceDefaultAndStatic;

public class FooImpl implements Foo {

    String name;

    public FooImpl(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);

    }



    @Override
    public String getName() {
        return this.name;
    }

}
