package interview.s16;

import java.util.Arrays;

public class s16 {
    public static void main(String[] args){
        int[] nums = new int[]{1,2};
        int k = 3 ;
        int[] ans = sumIsK(nums , k) ;
        System.out.println(ans[0] + " " + ans[1]);

    }
    public static int[] sumIsK(int[] nums , int k){
        if(nums == null || nums.length < 2){
            return null ;
        }
        Arrays.sort(nums);
        int i = 0 ;
        int j = nums.length - 1;
        while(i < j){
            int sumNow = nums[i] + nums[j] ;
            if(sumNow < k){
                i++ ;
            }else if(sumNow > k){
                j-- ;
            }else{
                return new int[]{i,j};
            }
        }
        return null ;
    }
}
