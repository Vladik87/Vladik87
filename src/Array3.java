import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

public class Array3 {
    //Создайте переменную для массива из 10 элементов. Заполните его произвольными значениями
    // целочисленного типа.Найдите максимальный элемент и выведите его индекс.
    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10);
        }
        System.out.println("initial array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "   ");
           IntStream intStream = Arrays.stream(array);
            OptionalInt optionalInt = intStream.max();
            int maxAsInt = optionalInt.getAsInt();
          System.out.println(Arrays.binarySearch(array,maxAsInt));





        }
    }
}