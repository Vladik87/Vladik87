import exception.ExitAppException;
import ui.UI;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Main {


    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        UI ui = new UI();
        try {
            ui.loginLoop();
            ui.mainLoop();
        } catch (ExitAppException e) {
            System.out.println("Работа завершена");
        }
    }
}
