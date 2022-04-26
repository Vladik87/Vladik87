package Home_work8;

import java.util.ArrayList;

public class Exception3 {



    public class Exception2 {
        public static class Print {
            void print(Object s) throws NullPointerException{
                if (s == null) {
                   // throw new NullPointerException("Опять НОЛЬ");
                }
                System.out.println("Печатуем " + s);
            }


            public static void main(String[] args) {
               Print print = new Print();
                ArrayList<Object> list = new ArrayList<>();
                list.add("Первое");
                list.add(null);
                list.add("Третье");
                for (Object s:list) {
                    try {
                        print.print(s);
                    }
                    catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Ввели NULL !!!");
                        System.out.println(" ");
                    }
                    finally {
                        System.out.println("Блок FINALLY");
                    }
                    System.out.println("ПРОДОЛЖАЕМ  ");
                    System.out.println(" ");
                }
            }
        }
    }
}
