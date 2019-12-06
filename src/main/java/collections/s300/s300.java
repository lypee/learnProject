package collections.s300;

public class s300 {
}
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0 ;
        }
        int[] dp = new int[nums.length] ;
        dp[0] =  1 ;
        int max = 1 ;
        for(int i = 1 ; i < nums.length ; i++){
            int maxval = 0 ;
            for(int j = 0 ; j  <  i ; j++){
                if(nums[i] > nums[j]){
                    maxval = Math.max(maxval , dp[j]);
                }
            }
            dp[i] = maxval + 1 ;
            max = Math.max(max , dp[i]) ;
        }
        return max ;
    }
}




class Solution2{
    public int lenghtOfLTS(int[] nums){
        if(nums.length == 0 || nums ==null){
            return 0 ;
        }
        int[] dp = new int[nums.length] ;
        dp[0] = 1 ;
        int ans = 0 ;
        for(int i = 1 ;  i < nums.length ; i++){
            int maxVal = 0 ;
            for(int j = 0 ; j < i ; j++){
                if(nums[i] > nums[j]){
                    maxVal = Math.max(maxVal , dp[j]);
                }
            }
            dp[i] = maxVal + 1  ;
            ans = Math.max(ans , dp[i]) ;
        }
        return ans ;
    }
}