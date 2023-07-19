package me.kwon.streamAPI;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("kwon");
        names.add("park");
        names.add("lee");
        names.add("choi");

        //원본 배열은 변경하지 않는다.
        List<String> collect = names.stream()
                .map(String::toUpperCase) //중계 오퍼레이션 : stream만을 return
                .filter(s -> s.length() > 3)
                .collect(Collectors.toList()); // 종료 오퍼레이션 : stream이 아닌 type을 return
        collect.forEach(System.out::println);

        System.out.println("---------------");
        //병렬적 처리
        List<String> collect1 = names.parallelStream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("K"))
                .collect(Collectors.toList());
        collect1.forEach(System.out::println);

        int[] arr = {90,27,43,88,3};
        Arrays.stream(arr)
                .filter(i -> i > 10)
                .sorted()
                .forEach(System.out::println);
    }
}
