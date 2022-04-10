import java.util.Random;

public class Array5 {
    //Создайте переменную для массива из 10 элементов. Заполните его произвольными значениями целочисленного типа.
    // Выведите на экран, переверните и снова выведите на экран (при переворачивании нежелательно создавать еще один массив).
    public static void main(String[] args) {
        Random rad = new Random();
        int [] a = new int[10];
        for(int i=0;i< a.length;i++){
            a[i]= rad.nextInt(10);
            System.out.print(a[i]);
            System.out.print(" ");

        }   for(int i = 9; i>=0; i--){

            System.out.print(a[i]);

        }
    }
}
