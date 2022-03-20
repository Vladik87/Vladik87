import java.text.DecimalFormat;

public class Task6 {
    //Задать произвольное целое число и вывести его в бухгалтерском формате, то есть, начиная справа,
    // каждые три позиции отделяются пробелом. Например, число 20023143 должно быть выведено как 20 023 143.
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("###,###");
        long a =20023143;
        System.out.println(df.format(a));
    }
}
