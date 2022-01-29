public class PrimeNumbers {

    public static  void main(String str[]){
        prime(250,300);
        //String s="abc";
        String s1= new String("abc");
        String s= new String(s1);
        System.out.println(s.equals(s1));
        System.out.println(s==s1);

        System.out.println(s); //abc
        s1="cdf";
        System.out.println(s);  // abc
        System.out.println(s1);  //cdf

    }

    private static void prime(int num1, int num2) {

        for(int i=num1;i<=num2;i++){
            if(isPrime(i))
                System.out.println(i);
        }
    }

    private static boolean isPrime(int i) {
        int count=0;
        for(int j=1;j<=i/2;j++)
            if(i%j==0)
                count++;

        if(count>1)
            return false;
        return true;
    }



}
