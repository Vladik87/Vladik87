import java.util.Random;

public class Array2 {
    //Создайте переменную для массива из 10 элементов (другим способом). Заполните его произвольными значениями целочисленного типа
    // и выведите на экран элементы, стоящие на четных позициях.
    public static void main(String[] args) {
        Random rand = new Random();
        int array[];
        array= new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10);
        }
        System.out.println("initial array:");
        for (int i = 0; i < array.length; i++) {

            if(i%2==0){
                System.out.println("индекс "+i+" = "+array[i]+",");
            }
           // System.out.println(array[0] +" "+ array[2]+" "+array[4]+" "+array[6]+" "+array[8]);
        }
    }
}
