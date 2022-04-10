public class Appliances {
    int power = 220;

    public void on() {
        boolean state = true;
        System.out.println("Питание влючено");
    }

    public void off() {
        boolean state = false;
        System.out.println("Питание выключено");
    }

}
