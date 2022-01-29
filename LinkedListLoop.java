public class LinkedListLoop {

    static class Node{
        int data;
        Node next;
        Node(int d){
            this.data=d;
            this.next=null;
        }
    }

    public static void main(String str[]){

        Node n = new Node(1);
        n.next = new Node(2);
//        n.next.next = new Node(3);
//        n.next.next.next = new Node(4);
//        n.next.next.next.next = new Node(5);
        //n.next.next.next.next.next= n.next;

        System.out.println(removeNthFromEnd(n,1));

    }

//    public static int lengthLoop(Node sl){
//
//        int count=1;
//        Node temp = sl.next;
//        while(temp.data!=sl.data){
//            count++;
//            temp=temp.next;
//        }
//        return count;
//
//    }
//    public static int findLoop(Node head){
//
//        Node sl=head;
//        Node fs=head;
//
//        while(sl!=null && fs!=null && fs.next!=null){
//            sl=sl.next;
//            fs=fs.next.next;
//
//            if(sl.data==fs.data){
//               return lengthLoop(sl);
//            }
//        }
//        return -1;
//    }
    public static Node removeNthFromEnd(Node head, int n) {

        Node temp = head;

        for(int i=0;i<n;i++){
            temp=temp.next;
        }

        Node temp2 = head;

        while(temp!=null){
            temp=temp.next;
            temp2=temp2.next;
        }

        Node temp3 = temp2.next;

        if(temp3==null){
            
            return head;
        }

        temp2.data=temp3.data;
        temp2.next=temp3.next;


        return head;
    }
}
