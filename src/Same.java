import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Same {

    public static void main(String[] args) {
        int numb = 7;
        List<Integer> q = new ArrayList<>();
        for (int i = 0; i < numb; i++) {
            int a = (int) (Math.random() * 10 + 1);

            q.add(i, a);
            System.out.println(q);
            List r = new ArrayList(new HashSet(q));
            System.out.println(r);
        }
    }
}
