package me.kwon.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE_USE) //더 유연하게 거의 모든곳에 에 붙일 수 있다.
@Retention(RetentionPolicy.RUNTIME)
public @interface ChickenContainer {
        Chicken[] value();
}
