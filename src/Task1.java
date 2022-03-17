public class Task1 {
    // Вычислить факториал целых чисел от 0 до 10 при помощи while
    public static void main(String[] args) {
        int x = 10;
        int i = 1;
        int r = 1;
        while (i <= x) {
            r = r * i;
            i++;

            System.out.println(r);

        }


    }
}
