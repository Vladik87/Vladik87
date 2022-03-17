public class Task2 {
   // Вычислить произведение чисел от 1 до 25 с помощью цикла do while.
    public static int multipli(){
        int resalt =1;
        int n=2;
        do {
            resalt=resalt*n;
            n++;
        }while (n<=25);
        return resalt;
    }
    public static void main(String[] args) {
        System.out.println(multipli());
    }
}
