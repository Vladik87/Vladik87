import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Arrey {
    public static void main(String[] args) {
        int stud = 6;
        int bad = 3;
        List<Integer> est = new ArrayList<>();
        for (int i = 0; i < stud; i++) {
            int a = (int)(Math.random() * 10 + 1);
            Integer b = a;
            est.add(i, b);
        }
        System.out.println(est);
        for(Iterator<Integer> z = est.iterator(); z.hasNext();)
        if(z.next()<= bad)
            z.remove();
        System.out.println(est);
        }
    }



