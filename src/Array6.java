import java.util.Arrays;

public class Array6 {
    public static void main(String[] args) {
        int [] [] a = new int[5][5];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                a [0][0]=1;
                a [0][1]= a [0][2]= a [0][3]= a [0][4]= a [0][0];
                a[4][4]=a[4][0]=a[4][1]=a[4][2]=a[4][3]=1;
                a[1][1]=a[1][2]=a[1][3]=1;
                a[2][2]=1;
                a[3][1]=a[3][2]=a[3][3]=1;
                System.out.print(""+a[i][j]+"");

            }
             System.out.println();
        }

    }
}
