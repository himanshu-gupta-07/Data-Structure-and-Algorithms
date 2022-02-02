import java.util.*;

public class KthMostFrequent {

    public static void main(String str[]){

        int arr []= {1,1,2,2,2,3,4,4,1,1,4,3,4,3,4,3,4,3,4};
        int ans[]=kMostFrequent(arr,2);
        for(int i=0;i<2;i++){
            System.out.print(ans[i]+" ");
        }
    }

    public static int[] kMostFrequent(int arr[], int k){

        int ans[]= new int[k];

        Map<Integer,Integer> map = new HashMap<>();

        for(int i: arr){
            int v = map.getOrDefault(i,0);
            map.put(i,v+1);
        }

        Queue<Integer> q = new PriorityQueue<>((n1,n2)-> map.get(n1)-map.get(n2));

        for(int ii : map.keySet()){
            q.add(ii);
            if(q.size()>k)
                q.poll();
        }

        for(int i=0;i<k;i++){
            ans[i]=q.poll();
        }

        return ans;
    }
}
