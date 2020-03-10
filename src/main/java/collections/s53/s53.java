package collections.s53;

public class s53 {
}
class Solution {
    public int maxSubArray(int[] nums) {
            if(nums.length == 0 || nums == null){
                return -1 ;
            }
            int sum = 0 ;
            int max=  Integer.MIN_VALUE ;
            for(int i = 0 ; i < nums.length ;i++){
                sum = Math.max(nums[i] , sum+nums[i]);
                max = Math.max(max , sum);
            }
            return max ;
    }
}