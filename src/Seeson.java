import java.util.Scanner;

public class Seeson {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.WINTER);
        Season season1 = Season.SPRING;
        Season season2 = Season.SUMMER;
        Season season3 = Season.AUTUMN;
        Season season4 = Season.WINTER;
        System.out.println(season4);

        Scanner console = new Scanner(System.in);
        System.out.println("Введите номер сезона от 1 до 4");
        int season = console.nextInt();

        if (season == 1) {
            System.out.println(season1);
        }else
        if (season == 2) {
            System.out.println(season2);
        }else
        if (season == 3) {
            System.out.println(season3);
        }else
        if (season == 4) {
            System.out.println(season4);
        } else {
            System.out.println("Такого сезона не существует");
        }day(season);

    }

    private static void day(int season) {

        if (season == 1) {
            int day = 31 * 2 + 30;
            System.out.println("Количество дней "+day);
        }if(season==2){
            int day = 31 * 2 + 30;
            System.out.println("Количество дней "+day);
        }if(season==3){
            int day=30*2+31;
            System.out.println("Количество дней "+day);
        }if(season==4){
            int day = 31*2+28;
            System.out.println("Количество дней "+day);
        }
    }
}




