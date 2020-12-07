package interview.s8;

public class s8 {
    public static void main(String[] args){
        System.out.println(new Solution().climbStairs(12));
    }
}
class Solution {
    int[] nums ;
    int ans = 0;
    public int climbStairs(int n) {
        if(n < 2 ){
            return 1 ;
        }
        if(n == 2 ){
            return 2 ;
        }
        nums = new int[n + 1];
        nums[0] = 0 ;
        nums[1] = 1 ;
        nums[2] = 2 ;
        dp(n , nums);
        return nums[n] ;
    }
    public void dp(int n, int[] nums){
        for(int i = 3 ; i <= n ;i++){
            nums[i] = nums[i-1]  + nums[i-2];
        }
    }
}