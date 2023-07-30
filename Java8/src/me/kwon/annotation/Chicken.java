package me.kwon.annotation;

import java.lang.annotation.*;

//@Target(ElementType.TYPE_PARAMETER) //Generic 에 붙일 수 있다.
@Target(ElementType.TYPE_USE) //더 유연하게 거의 모든곳에 에 붙일 수 있다.
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ChickenContainer.class)
public @interface Chicken {

    String value();


}
