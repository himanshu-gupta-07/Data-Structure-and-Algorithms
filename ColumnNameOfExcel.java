import java.util.Scanner;

public class ColumnNameOfExcel {
    public static void main(String args[]){
        int l;
        Scanner sc= new Scanner(System.in);
        l=sc.nextInt();
        System.out.println(colName(l));
    }
    static String colName(int n)
    {
        int start=1;
        int rem=0;
        int i=1;
        String s="";
        while(start<=n){
            char c= (char) ('A'+start%26-1);
            s+=c;
            i++;
            rem=n-start%n;
            start= (int) (start+Math.pow(26,i));
        }

        char c=(char)('A'+rem%26);
        s+=c;

        return s;

    }
}
