package collections.s46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class s46 {
}
class Solution {
    List<List<Integer>> ans = new ArrayList<>() ;
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        helper(nums , 0 , nums.length);
        return ans ;
    }
    public void helper(int[] nums , int i , int j){
        if(i == j){
            List<Integer> list = new LinkedList<>() ;
            for(Integer integer : nums){
                list.add(integer) ;
            }
            ans.add(list) ;
            return ;
        }else{
            for(int index = i ; index < j ; index++){
                swap(nums , i , index) ;
                helper(nums , i+1 ,j);
                swap(nums , i , index);
            }
        }
    }
    public void swap(int[]nums , int i , int j ){
        int tmp = nums[i] ;
        nums[i] = nums[j] ;
        nums[j] = tmp ;
    }

}