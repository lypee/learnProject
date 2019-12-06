package interview.s3;

import java.util.Arrays;

public class s3 {
    public static void main(String[] args){
        int[] nums = {0 ,-1};
        System.out.println(new Solution().longestConsecutive(nums));
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length < 1 ){
            return 0 ;
        }
        if(nums.length == 1 ){
            return 1 ;
        }
        Arrays.sort(nums);
        int ans = 1 ;
        int tmp = 1;
        for(int i = 0 ; i < nums.length -1  ; i++){
            if(nums[i] + 1 == nums[i+1]){
                tmp++ ;
            }else{
                ans = Math.max(ans  , tmp );
                tmp = 1 ;
            }
        }
        ans = Math.max(ans  , tmp );
        return ans ;
    }
}