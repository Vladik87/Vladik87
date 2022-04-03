package Home_work6;

public interface card {
    default void pay() {
        System.out.println("Списание средств");
    }
}
