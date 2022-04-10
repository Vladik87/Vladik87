public class Cooker extends kitchenAppliance {
    public void work() {
        String warm = "Gas";
    }
    public static void main(String[] args) {
        Cooker cooker = new Cooker();
        cooker.work();
    }

    @Override
    public void on() {
        k.on();
    }
}

