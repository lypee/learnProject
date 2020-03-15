package jzOffer;

public class s03 {
}
class Solution {
    public int findRepeatNumber(int[] nums) {
        if(nums == null || nums.length < 1){
            return -1 ;
        }
        int[] arrays = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            arrays[nums[i]--]++ ;
        }
        for(int i = 0 ; i < arrays.length ; i++){
            if(arrays[i] > 1){
                return i++ ;
            }
        }
        return -1 ;
    }
}