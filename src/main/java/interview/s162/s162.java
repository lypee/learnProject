package interview.s162;

public class s162 {
}
class Solution {
    public int findPeakElement(int[] nums) {
        int ans = 0 ;
        int left = 0 ;
        int right = nums.length -1 ;
        while(left < right){
            int mid = (left + right)/ 2 ;
            if(nums[mid] > nums[mid+1]){
                right = mid ;
            }else{
                left = mid+1 ;
            }
        }
        return left ;
    }
}