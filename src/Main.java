import exception.ExitAppException;
import ui.UI;

public class Main {


    public static void main(String[] args) {
        UI ui = new UI();
        try {
            ui.loginLoop();
//            ui.mainLoop();
        } catch (ExitAppException e) {
            System.out.println("Работа завершена");
        }
    }
}
