package interview.s315;

import java.util.ArrayList;
import java.util.List;

public class s315 {
}
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] ans = new int[nums.length] ;
        List<Integer> ansList = new ArrayList<>(nums.length) ;
        for(int i = 0 ; i< nums.length-1 ;i++){
            for(int j = i+1 ; j < nums.length ;j++){
                if(nums[i] > nums[j]){
                    ans[i]++ ;
                }
            }
        }
        return null ;
    }
}
