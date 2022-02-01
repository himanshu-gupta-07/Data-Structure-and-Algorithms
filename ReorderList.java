
public class ReorderList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode (int v){
            this.val=v;
            this.next=null;

        }
    }
    public static void printL(ListNode n){
        ListNode t = n;
        while(t!=null){
            System.out.print(t.val + "->");
            t=t.next;
        }
        System.out.println();
    }
    public static void main(String str[]){

        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);

        reorderList(n);

        printL(n);

    }

    private static void reorderList(ListNode n) {

        ListNode prev = null;
        ListNode slow = n;
        ListNode fast = n;

        ListNode n1 = n;

        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;

        }

        prev.next =null;


        ListNode n2= reverse(slow);

        printL(n1);
        printL(n2);

        merge(n1,n2);

    }

    private static void merge(ListNode n1, ListNode n2) {

        while(n1!=null){
            ListNode n1_next = n1.next;
            ListNode n2_next = n2.next;

            n1.next = n2;
            
            if(n1_next==null)
                break;

            n2.next = n1_next;

            n1=n1_next;
            n2=n2_next;
        }
    }

    private static ListNode reverse(ListNode slow) {

        ListNode prev = null;
        ListNode curr = slow;
        ListNode next = slow;

        while(curr!=null){

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
