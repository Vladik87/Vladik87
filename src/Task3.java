public class Task3 {
    //Посчитать сумму цифр числа 7893823445 с помощью цикла do while.
    public static void main(String[] args) {

        long a;
        a = 7893823445l;
        long x =  a;
        int s = 0;
        do {
            s += x % 10;
            x /= 10;
        }
        while (x != 0);
        System.out.println("Сумма цифр числа " + a + " =" + s);
    }

}


