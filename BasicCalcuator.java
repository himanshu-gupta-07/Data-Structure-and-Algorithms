import java.util.Scanner;
import java.util.Stack;

//Work only if given string is valid and has integer 0-9
public class BasicCalcuator {
    public static void main(String str[]){
        Scanner sc= new Scanner(System.in);
        String s1=sc.nextLine();

        System.out.println(calc(s1));


    }

    private static int calc(String s) {
        Stack<Character> st = new Stack<Character>();
        int n= s.length();
        int ans=0;

        int i=0;
        while(i<n){
            if(s.charAt(i)=='*' || s.charAt(i)=='/'){
                int num2= Character.getNumericValue(s.charAt(i+1));
                int num1= Character.getNumericValue(st.pop());
                if(s.charAt(i)=='*')
                    ans+=num2*num1;
                else
                    ans+=num1/num2;
                st.push((char)(ans+'0'));
                i+=2;
            }else{
                st.push(s.charAt(i));
                i++;
            }
        }
        if(st.size()==1)
            return st.pop();

        int ans2=0;
        while(!st.empty()){
            int c= Character.getNumericValue(st.pop());
            if(st.peek()=='+' || st.peek()=='-'){
                char op=st.pop();
                int num2= Character.getNumericValue(st.pop());
                if(op=='+')
                    ans2+=num2+c;
                else
                    ans2+=num2-c;
            }
        }

        return ans2;
    }
}
