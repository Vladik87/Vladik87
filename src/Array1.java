import java.util.Arrays;
import java.util.Random;

public class Array1 {
    //Создайте переменную для массива из 10 элементов. Заполните его произвольными значениями целочисленного типа
    // и выведите последний элемент массива на экран.
    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10);
        }
        System.out.println("initial array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "   ");
            System.out.println(array[9]+" " );




        }



    }
}
