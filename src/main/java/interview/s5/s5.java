package interview.s5;

import java.util.ArrayList;
import java.util.List;

public class s5 {

}
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>() ;
        public List<List<Integer>> permute(int[] nums) {
            helper(nums , 0 , nums.length);
            return ans ;
        }
        public void helper(int[] nums , int i , int j){
            if(i == j){
               ArrayList<Integer> tmpList = new ArrayList<>();
               for(Integer integer : nums){
                   tmpList.add(integer);
               }
                ans.add(tmpList);
               return ;
            }
                for(int index = i ; index < j ; index++){
                    swap(nums, i , index);
                    helper(nums , i+ 1 , j);
                    swap(nums , i , index);
                }

        }
        public void swap(int[] nums, int i , int j){
            int tmp = nums[i];
            nums[j] = nums[i];
            nums[i] = tmp ;
        }
    }