public class Task4 {
    public static void main(String[] args) {
//Найти среди чисел от 50 до 70 второе простое число
// (число называют простым,если оно делится без остатка только на 1 и себя) и завершить цикл с использованием break.
                for (int a = 50; a <= 70; a++) {
                for (int i = 2; i <= a; i++) {
                if(i < a & a % i ==0){
                    break;
                }
                if(i%a==0)
                    System.out.println(a);
                }
            }
        }
    }

