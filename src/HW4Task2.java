import java.util.Scanner;

public class HW4Task2 {

        public static class ATM {
            int cash20;
            int cash50;
            int cash100;
            int allcash;

            int n;
            public void zapolnenieATM() {
                if (allcash <= cash20) {
                    cash20 = 100;
                    cash50 = 100;
                    cash100 = 100;
                    allcash = (cash20 * 20) + (cash50 * 50) + (cash100 * 100);
                }
                // System.out.println(allcash);
            }

            public void getCash() {
                System.out.println("Введите сумму.  ");
                Scanner a = new Scanner(System.in);
                int cash = a.nextInt();
                if (cash < 20) {
                    System.out.println("Данная сумма не доступна");
                }
                if (cash % 20 == 0 || cash % 50 == 0 || cash % 100 == 70 && cash < allcash) {
                }
                if (cash % 100 == 0) {
                    int res = cash / 100;
                    System.out.println("Возмите деньги " + res + " номиналом cash 100");
                } else {if (  cash % 100 == 70 ) {
                    int m = (cash-20)/50;
                    int res=1;
                    System.out.println("Возмите деньги " + res + " номиналом cash 20");
                    System.out.println("возмите деньги "+m+" номиналом cash 50");
                    } else { if(cash%100==50){
                    int res = (cash-50)/100;
                    int f=1;
                    System.out.println("Возмите деньги "+f+" Номиналом cash 50");
                    System.out.println("Возмите деньги "+res+" номиналом cash 100");

                        }else { if(cash%100==20){
                            int res = (cash-20)/100;
                            int f=1;
                            System.out.println("Возмите деньги "+f+" Номиналом cash 20");
                            System.out.println("Возмите деньги "+res+" номиналом cash 100");
                        }else {
                            if (cash % 20 == 0) {
                            int res = cash / 20;
                            System.out.println("Возмите деньги " + res + " номиналом cash 20");
                                }else { if ( cash % 50 == 0 ) {
                                int res = cash / 50;
                                System.out.println("Возмите деньги " + res + " номиналом cash 50");

                                }else {
                                System.out.println("Неверная сумма!!!");
                            }
                            }
                            }
                    }

                }
            }
        }}

            public static void main(String[] args) throws InterruptedException {
                ATM at = new ATM();
                at.cash20 = 0;
                at.cash50 = 0;
                at.cash100 = 0;
                at.allcash = 0;
                at.zapolnenieATM();
                System.out.println("Выберите операцию: 1-пополнение. 2-снятие. 0-выход ");
                Scanner keyboard = new Scanner(System.in);
                int a = keyboard.nextInt();
                if (a == 1) {
                    System.out.println("Введите сумму.  ");
                    Scanner mane = new Scanner(System.in);
                    int sum = mane.nextInt();
                    if (sum > 0) {
                        at.allcash = at.allcash + sum;
                        System.out.println("Операция проведена успешно");
                    } else {
                        if (sum <= 0) {
                            System.out.println("Неверная сумма");
                        }
                    }
                }
                if (a == 2) {
                    at.getCash();
                }
            }
        }





