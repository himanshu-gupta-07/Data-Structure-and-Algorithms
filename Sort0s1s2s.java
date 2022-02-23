/*
* Sort array with 0s, 1s and 2s
* // 0 2 1 2 0
* i=0,j=4,mid=2
* 0 2 1 2 0
* i=0,j=4,mid=3
* 0 2 1 0 2
* i=0,j=3,mid=3
* 0 2 1 0 2
* i=1,j=3,mid=3
* 0 0 1 2 2
* i=2,j=3,mid=3
* 0 0 1 2 2
* i=2,j=2,mid=3
* */
public class Sort0s1s2s {

    public static void swap(int i, int j, int arr[]){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
    public static int[] getSorted(int arr[]){

        int i=0;
        int j=arr.length-1;
        int mid = 0;
        while(mid<=j){
            if(arr[mid]==0){
                swap(i,mid,arr);
                i++;
                mid++;
            }else if(arr[mid]==1){
                mid++;
            }else{
                swap(mid,j,arr);
                j--;
            }
        }

        return arr;
    }
}
