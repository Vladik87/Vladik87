import loger.LogLevel;
import loger.Loger;

public class Main {
    Loger loger =  Loger.getInstance();
    public static void main(String[] args) {
       Main main = new Main();
       main.kek();
    }
    public void kek(){
        loger.log(this.getClass(), LogLevel.DEBUG,"Debug message");
    }
}
