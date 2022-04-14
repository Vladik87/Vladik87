import java.util.Scanner;

public class Garage <T extends Vehicle>{
    public static void main(String[] args) {
        Garage car = new Garage();
        Scanner console = new Scanner(System.in);
        System.out.println("Введите первое авто");
        String car1 = console.nextLine();
        Scanner console1 = new Scanner(System.in);
        System.out.println("Введите второе авто");
        String car2 = console1.nextLine();

        Garage motorcycle = new Garage();
        Scanner console2 = new Scanner(System.in);
        System.out.println("Введите первый мотоцыкл");
        String moto = console2.nextLine();
        Scanner console3 = new Scanner(System.in);
        System.out.println("Введите второй мотоцыкл");
        String moto3 = console3.nextLine();
        System.out.println("Транспорт хранимый в гараже "+car1+" "+car2+" "+moto+" "+moto3);
    }


}
