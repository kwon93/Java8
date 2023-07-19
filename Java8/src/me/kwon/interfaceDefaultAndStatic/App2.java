package me.kwon.interfaceDefaultAndStatic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Spliterator;

public class App2 {
    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<>();
        name.add("kwon");
        name.add("park");
        name.add("lee");
        name.add("choi");

        //Iterable의 기본 메서드 1. forEach
        name.forEach(System.out::println);
        System.out.println("-----------");

        //Iterable의 기본 메서드 2. spliterator : iterator 와 비슷
        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit(); //기존에 있던것을 절반으로 나눔
        System.out.println("-----------");
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("-----------");

        //Collection의 기본 메서드 1. removeIf
        name.removeIf(s -> s.startsWith("l"));
        name.forEach(System.out::println);


        //Collection의 기본 메서드 2. stream
        long k = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("L"))
                .count();
        System.out.println(k);

        //Comparator 기본 메서드 1. reversed
        name.sort(String::compareToIgnoreCase); //문자순으로 순정렬
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed()); //문자를 역정렬


    }
}
