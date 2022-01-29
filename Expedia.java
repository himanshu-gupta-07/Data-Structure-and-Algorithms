import java.util.HashSet;
import java.util.Scanner;

public class Expedia {

    public static void main(String str[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(findDuplicate("arr"));
    }
    // 3,2,4,1,0,3,5
    //1,1,3,7,0,
    //1,6,2,4,7,1
    //1,2,3,4,5,6
    //6,5,4,3,2,1

    //2,1,3,4,0   target 2
    //1
    //-2,1,2,0,4  target 0
    //0,1,8,2,
    //2,1,2,3   target 4

    //abcad
    //abcdef
    //aaaaaa
    //

    public static boolean findDuplicate(String s){

        //target-arr[i]
        if(s==null||s.length()<2)
            return false;

        if(s.length()>256)
            return true;


        HashSet<Character>set = new HashSet<>();

        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i)))
                return true;
            set.add(s.charAt(i));
        }

        return false;

//        int st= 0;
//        int en= arr.length-1;
//
//
//        while(st<=en){
//            int mid= (st+en)/2;
//
//            if(arr[mid]==target)
//                return mid;
//
//            if(arr[mid]>target){
//                en=mid-1;
//            }else{
//                st=mid+1;
//            }
//
//        }
//
//        return -1;

//        if(st>=en)
//            return -1;
//
//        int mid= st+en/2;
//
//        if(arr[mid]==target)
//            return mid;
//
//        int left=-1;
//        int right=-1;
//        if(arr[mid]>target){
//            en=mid-1;
//            left=findIndex(arr,target,st,en);
//        }else{
//            st=mid+1;
//            right=findIndex(arr,target,st,en);
//        }
//
//        if(left!=-1)
//            return left;
//        if(right!=-1)
//            return right;
//
//        return -1;

    }



}
