import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Max {
    public static void main(String[] args) {
        int stud = 20;
        List<Integer> est = new ArrayList<>();
        for (int i = 0; i < stud; i++) {
            int a = (int)(Math.random() * 30 + 1);

            est.add(i, a);
                    }
        System.out.println(est);
        System.out.println(Collections.max(est));
        }

    }

