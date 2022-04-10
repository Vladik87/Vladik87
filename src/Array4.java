import java.util.ArrayList;
import java.util.Random;

public class Array4 {
   // Создайте переменную для массива из 10 элементов. Заполните его произвольными значениями
   // целочисленного типа. Определите сумму элементов массива, расположенных между минимальным
   // и максимальным значениями. Если значений максимальных и минимальных несколько, то необходимо
   // взять максимальное значение разницы индексов между максимальным и минимальным значениями.
    public static void main(String[] args) {

        int[] a = new int[10];//создаем масив
        int p_min = 0;
        int p_max = 0;
        for (int i = 0; i < a.length; i++) {

            random_arr(a); // заполняем его
            printf_arr(a); // выводи на экран

            int a_min = min_ind(a); // миним. индекс
            int a_max = max_ind(a); // мах. индекс


            ArrayList<Integer> min_positions = new ArrayList<>();
            ArrayList<Integer> max_positions = new ArrayList<>();

            for (i = 0; i < 10; i++) {
                if (a[i] == a_min)
                    min_positions.add(i);
                if (a[i] == a_max)
                    max_positions.add(i);
            }
            int ind_max = 0;
            int rez;
            for (Integer x : min_positions)
                for (Integer y : max_positions) {
                    rez = Math.max(x, y) - Math.min(x, y);
                    if (rez > ind_max) {
                        ind_max = rez;
                        p_min = x;
                        p_max = y;
                    }
                }
            int n_sum = sum_array(a, p_min, p_max);//выводим сумму элементов
            System.out.printf("sum a[%d : %d] = %d\n",
                    Math.min(p_min, p_max), Math.max(p_min, p_max), n_sum);
        }



    }

    private static void random_arr (int[] a) {
        Random rnd = new Random( System.currentTimeMillis() );
        for (int i = 0; i < a.length; i++)
            a[i] = rnd.nextInt(10) ;
    }
    private static void printf_arr (int[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.printf("%4d", i); //индексы
        System.out.println();
        for (int n: a)
            System.out.printf("%4d", n); // элементы
        System.out.println();
    }

    private static int sum_array (int[] array, int a, int b) {
        int n_sum = 0;
        int start = Math.min(a, b);
        int finish = Math.max(a, b);
        for (int i = start + 1; i < finish; i++)
            n_sum += array[i];
        return n_sum;
    }

    private static int max_ind (int a[]) {
        int p_max = 0;
        for (int i = 1; i < a.length; i++)
            if (a[i] > a[p_max])
                p_max = i;
        return a[p_max];
    }

    private static int min_ind (int a[]) {
        int p_min = 0;
        for (int i = 1; i < a.length; i++)
            if (a[i] < a[p_min])
                p_min = i;
        return a[p_min];
    }
}




