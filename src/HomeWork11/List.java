package HomeWork11;


import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class List {
    public static void main(String[] args) {
        System.out.println("Введите размар  ");
        Scanner a = new Scanner(System.in);
        int n = a.nextInt();
        boolean intList = new Random().ints(n, MIN_VALUE, MAX_VALUE)
                .boxed().toList()
                .stream().peek(System.out::println)
                .anyMatch(x->((x%3==0) && (x%5==0)) );


        System.out.println(intList);
    }
}