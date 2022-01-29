import java.util.ArrayList;
import java.util.Stack;


public class SpiralLevelOrderTraversal {

    static class Node{
        int data;
        Node left;
        Node right;
    }
    ArrayList<Integer> findSpiral(Node root) {

        if(root == null)
            return new ArrayList<Integer>();

        ArrayList<Integer> ans = new ArrayList<>();

        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();

        s1.push(root);
        boolean check = true;
        while(!s1.isEmpty()){

            int n = s1.size();
            check = !check;
            s2 = s1;
            s1= new Stack<>();

            for(int i=0;i<n;i++){

                Node temp = s2.pop();
                ans.add(temp.data);

                if(check){
                    if(temp.right!=null)
                        s1.push(temp.right);

                    if(temp.left != null)
                        s1.push(temp.left);

                }else{
                    if(temp.left!=null)
                        s1.push(temp.left);

                    if(temp.right != null)
                        s1.push(temp.right);
                }

            }
        }
        return ans;
    }
}
