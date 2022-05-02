package HomeWork11;

import java.util.*;
import java.util.List;

public class STREAM {
    public static void main(String[] args) {
        List<Integer> duim = new ArrayList<>();
        duim.add(1);
        duim.add(2);
        duim.add(3);
        duim.add(4);
        duim.add(5);
        duim.add(6);
        duim.add(7);
        duim.add(8);
        duim.add(9);
        duim.add(10);
        duim.add(11);
        duim.add(12);
        duim.add(13);
        duim.add(14);
        duim.add(15);
        duim.add(16);
        duim.add(17);
        duim.add(18);
        duim.add(19);
        duim.add(20);

        double f = duim.stream().filter(x -> x % 2 == 0)
                        .mapToDouble(x -> x * 2.54)
                        .sum();
        System.out.println(f);


    }
}
