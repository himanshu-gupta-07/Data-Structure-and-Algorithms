import java.util.HashMap;
import java.util.Vector;

public class DeleteNodeFromBinaryTree {

    static class Node {
        int key;
        Node left, right;
    };

    static Node newNode(int key) {
        Node temp = new Node();
        temp.key = key;
        temp.left = temp.right = null;
        return (temp);
    }


    public static void main(String[] args) {

        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        //root.right.left = newNode(6);
        root.right.right = newNode(6);
        root.right.right.left = newNode(7);

        HashMap<Integer,Integer> map= new HashMap<>();

        map.put(null,null);

        System.out.println(removeNode(root, 4));
    }

    //function to store root of subtrees in vector
    private static Vector<Integer> removeNode(Node root, int data) {
        Vector<Integer> ans = new Vector<>();

        if(rootOfSubTrees(root, ans, data) != null)
            ans.add(root.key);

        return ans;
    }

    //function to find root of subtrees using postOrder/preOrder Traversal
    private static Node rootOfSubTrees(Node root, Vector<Integer> ans, int data) {

        if(root == null)
            return null;

        root.left = rootOfSubTrees(root.left, ans, data);


        if(root.key == data){
            if(root.right != null)
                ans.add(root.right.key);

            if(root.left != null)
                ans.add(root.left.key);

            return null;
        }

        root.right = rootOfSubTrees(root.right, ans, data);

        return root;
    }
}

// Time Complexity O(N)
// Space Complexity O(N) {For the stack space of recursion calls}
// N- Number of Nodes in Tree
