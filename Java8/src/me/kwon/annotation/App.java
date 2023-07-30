package me.kwon.annotation;

import java.util.Arrays;
import java.util.List;

@Chicken("양념")
@Chicken("뿌링클")
public class App {
    public static void main(String[] args) throws RuntimeException {
//        List<@Chicken String> names = Arrays.asList("kwon");
        Chicken[] chickens = App.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach(System.out::println); //해당 Annotation 에서 value를 뽑는 방법

        ChickenContainer chickenContainer = App.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(System.out::println); //Annotation을 감싼 Container에서 뽑는 방법.
    }


    static class FeelsLikeChicken<@Chicken("마늘간장") T> {

        public static <@Chicken("반반") C> void  print(@Chicken("후라이드") C c){
            System.out.println(c);
        }
    }

}
