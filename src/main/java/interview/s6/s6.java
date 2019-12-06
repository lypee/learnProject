package interview.s6;

import java.util.ArrayList;
import java.util.List;

public class s6 {
    public static void main(String[] args){
        int[] ans = new Solution().plusOne(new int[]{9,9,9});
        for(Integer integer : ans){
            System.out.print(integer +  " ");
        }
    }
}
class Solution {
    public int[] plusOne(int[] digits) {

        boolean flag = false ;
        digits[digits.length -1]++ ;
        for(int i = digits.length -1 ; i >= 0 ; i--){
            if(flag){
                digits[i]++ ;
            }
            flag = false ;
            if(digits[i] == 10){
                digits[i] = 0 ;
                flag = true ;
            }
            if(flag && i == 0){
               int[] ans =  helper(digits);
               return ans ;
            }
        }
        return digits ;

    }
    public int[] helper(int[] digits){
        digits[0] = 0;
        int[] ans = new int[digits.length + 1 ];
        ans[0] =1 ;
        for(int i = 0 ; i < digits.length ; i++){
            ans[i+1] = digits[i];
        }
        return ans ;
    }
}