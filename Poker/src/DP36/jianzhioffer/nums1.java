package DP36.jianzhioffer;

public class nums1 {

    public int duplicateArray(int[] nums){
        int n = nums.length;
        for(int x : nums){
            if(x < 0 || x >= n){
                return -1;
            }
        }
        for(int i = 0; i < n; i++){
            while(i != nums[i] && nums[i] != nums[nums[i]]){
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = temp;
            }
            //[2, 3, 5, 4, 3, 2, 6, 7]
            //[5, 3, 2, 4, 3, 2, 6, 7]
            //[2, 3, 0, 4, 3, 2, 6, 7]
            //[0, 3, 2, 4, 3, 2, 6, 7]
            //[0, 4, 2, 3, 3, 2, 6, 7]
            if(i != nums[i] && nums[i] == nums[nums[i]]){
                return nums[i];
            }
        }
        return -1;
    }
}
