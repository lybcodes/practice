//package Alibaba;
//
//import java.util.Arrays;
//
//public class Main7 {
//    public static void main(String[] args) {
//        int[] da1 = new int[]{1,3,5};
//        int[] da2 = new int[]{2,4,6};
//        System.out.println(da2[da1[0]]);
//        System.out.println(da1[da2[0]]);
//    }
//    public static int sort(int[] a, int target, int l, int r){
//        //先给数组排序
//        Arrays.sort(a);
//        if(target < a[l] || target > a[r] || l > r){
//            return -1;
//        }
//        if(l < r){
//            int mid = l + r >> 1;
//            if(target == a[mid]){
//                return mid;
//            }else if(target > a[mid]){
//                sort(a, target, mid, r);
//            }else{
//                sort(a, target, l, mid - 1);
//            }
//        }
//        String s = new String()
//        return -1;
//    }
//}
