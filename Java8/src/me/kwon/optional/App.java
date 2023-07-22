package me.kwon.optional;

import me.kwon.streamAPI.OnlineClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<me.kwon.streamAPI.OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new me.kwon.streamAPI.OnlineClass(1,"spring boot", true));
        springClasses.add(new me.kwon.streamAPI.OnlineClass(2,"spring data JPA", true));
        springClasses.add(new me.kwon.streamAPI.OnlineClass(3,"spring mvc", false));
        springClasses.add(new me.kwon.streamAPI.OnlineClass(4,"spring core", false));
        springClasses.add(new OnlineClass(5,"rest api development", false));

        OnlineClass2 springBoot = new OnlineClass2(1, "spring boot", true);


    }
}
