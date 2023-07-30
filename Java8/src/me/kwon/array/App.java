package me.kwon.array;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        //배열의 병렬 정렬
        int size = 1500;
        int[] numbers = new int[size];
        Random random = new Random();
        IntStream.range(0,size).forEach(i -> numbers[i] = random.nextInt());

        long start = System.nanoTime();
        Arrays.sort(numbers); //우리가 그동안 쓰던 정렬 쓰레드를 한개만 쓴다.
        System.out.println("serial sorting took "+ (System.nanoTime() - start));

        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());
        start = System.nanoTime();
        Arrays.parallelSort(numbers); //멀티 쓰레드 사용
        System.out.println("parallel sorting took "+ (System.nanoTime() - start));
    }
}
