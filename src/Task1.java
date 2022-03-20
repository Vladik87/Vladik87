import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.net.SocketOption;

public class Task1 {
    // Вычислить факториал целых чисел от 0 до 10 при помощи while
    public static void main(String[] args) {
        int x = 2;
        int i = 1;
        int r = 1;
        if(x==0){
            System.out.println(r);
        }else {
        while (i <= x) {
            r = r * i;
            i++;

            System.out.println(r);
        }
        }


    }
}
