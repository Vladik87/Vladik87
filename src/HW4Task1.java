public class HW4Task1 {
    public static class Time{
        long hour;
        long minn;
        long sek;
        long allsek(){
            long allsek =(hour*60*60)+(minn*60)+sek;
            System.out.println("Общее кол-во секунд "+allsek);
            return allsek;
        }
        public Time(long sek) {
            this.sek=sek;
            System.out.println("Время (only seconds) = " + sek);
        }
        public Time(long hour,long minn,long sek){
            this.hour=hour;
            this.minn=minn;
            this.sek=sek;

        }
        public void printDifTime() {
            System.out.println(String.format("Время %s hours, %s minuts, %s seconds", hour, minn, sek));
        }
        public static void main(String[] args) {
            Time a =new Time(2359);
          //  a.hour=665; проверял работу allsek
          //  a.minn=6555;
          //  a.sek=58997;
            a.allsek();
            a.printDifTime();
            Time b = new Time(25,5687,5889);
           // b.hour=665;
           // b.minn=6555;
           // b.sek=45697;
            b.allsek();
            b.printDifTime();
            System.out.println(a==b);
            Time c =a;
            System.out.println(c==a);
        }


    }
}
