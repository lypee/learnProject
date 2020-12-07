package interview.s13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class s13 {
    public static void main(String[] args){
        int[] nums = new int[]{1, 2, 3} ;
        Solution s = new Solution(nums) ;
        s.helper(nums , 0 , nums.length);

        for(Integer integer : s.shuffle()){
            System.out.print(integer+ " ");
        }
        //        List<List<Integer>> ans =s.ans;
//        for(List<Integer> list : ans){
//            for(Integer integer : list){
//                System.out.print(integer + " ");
//            }
//            System.out.println();
//        }

    }
}
class Solution {
    int[] backNums ;
    int[] nums ;
    List<List<Integer>> ans = new ArrayList<>() ;
    public Solution(int[] nums) {
        if(nums.length == 0 || nums == null){
            return ;
        }
        this.nums = nums.clone() ;
        this.backNums = nums.clone() ;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        nums = backNums.clone() ;
        return nums ;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums == null){
            return new int[]{} ;
        }
        Arrays.sort(nums);
        helper(nums , 0 , nums.length);
        int size = ans.size() ;
        int randomNumber = (int)(Math.random() * size) ;
        return ans.get(randomNumber).stream().mapToInt(Integer::valueOf).toArray() ;
    }
    public void helper(int[] nums , int i , int j){
        if(i == j){
           List<Integer> list = new ArrayList<>() ;
           for(Integer integer : nums){
               list .add(integer) ;
           }
           ans.add(list) ;
           return ;
        }
        for(int index =  i ; index < j ;index++){
            swap(nums , i , index);
            helper(nums,  i+1 , j);
            swap(nums, i, index);
        }
    }
    public void swap(int[] nums , int i , int j){
        int tmp = nums[i] ;
        nums[i] = nums[j]  ;
        nums[j] = tmp ;
    }
}
class Solution2 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        helper(nums,  0 , nums.length);
        return ans ;
    }
    public void helper(int[] nums ,  int i , int j)
    {
        if(i == j)
        {
            List<Integer> list = new ArrayList<>();
            for(Integer integer : nums)
            {
                list.add(integer);
            }
            ans.add(list);
            return;
        }
        for(int index = i ; index < j ; index++)
        {
            swap(nums , i , index);
            helper(nums,  i+1 , j);
            swap(nums, i, index);
        }
    }
    public void swap(int[] nums , int i , int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp ;
    }
}