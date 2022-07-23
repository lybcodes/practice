package Alibaba;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main3 {

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,6,1};
        countSmaller(nums);
        System.out.println(res.toString());
    }

    //归并排序+索引数组
    private static int[] res;
    private static List<Integer> countSmaller(int[] nums) {
        res = new int[nums.length];
        int[] indexes = new int[nums.length];//索引数组，储存每个元素的下标
        for(int i = 0; i < indexes.length; i++){
            indexes[i] = i;
        }
        mergeSort(nums, indexes, 0, indexes.length -1);
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }
    private static void mergeSort(int[] nums, int[] indexes, int l, int r){
        if(l >= r) return;
        int mid = l + r >> 1;
        mergeSort(nums, indexes, l, mid);
        mergeSort(nums, indexes, mid + 1, r);
        merge(nums, indexes, l, mid, r);
    }
    private static void merge(int[] nums, int[] indexes, int l, int mid, int r){
        int[] temp = new int[nums.length];
        int i = l, j = mid + 1, k = 0;
        while(i <= mid && j <= r){//从大到小排
            if(nums[indexes[i]] <= nums[indexes[j]]){
                temp[k++] = indexes[j++];
            }else{
                temp[k] = indexes[i];
                res[temp[k]] += r - j + 1;
                k++;
                i++;
            }
        }
        while(i <= mid) temp[k++] = indexes[i++];
        while(j <= r) temp[k++] = indexes[j++];

        k = 0;
        while(l <= r){
            indexes[l++] = temp[k++];
        }
    }
}
