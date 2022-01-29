import java.util.Stack;

public class DecodeString {

    public static  void main(String str[]){
        System.out.println(decodeString("3[a2[c]]"));
    }

    public static String decodeString(String s) {

        int n= s.length();
        int i=0;
        String ans="";
        Stack<Character> st= new Stack<Character>();
        while(i<n){
            char c= s.charAt(i);
            if(c==']'){
                String lans="";

                while(!st.isEmpty() && st.peek()!='[')
                    lans=st.pop()+lans;

                st.pop();
                int no=Integer.parseInt(String.valueOf(st.pop()));
                String ch=lans;
                for(int k=0;k<no-1;k++)
                    lans+=ch;

                ans+=lans;
            }else
                st.push(c);

            i++;
        }
        return ans;
    }
}
