package collections.s53;

public class s53 {
}
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0  ;
        int ans = Integer.MIN_VALUE ;
        for(int i = 0 ; i < nums.length ; i++){
            sum = Math.max(nums[i], sum + nums[i]);
            ans = Math.max(sum, ans);
        }
        return ans ;
    }
}