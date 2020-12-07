package collections.s12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class s12 {
    public static void main(String[] args)throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> outputList = new ArrayList<>();
        Solution solution = new Solution();
        while(true){
            int number = Integer.parseInt(buf.readLine());
            if(number <= 0){
                break ;
            }else{
                outputList.add(solution.GetSpecNum(number));
            }
        }
        for(Integer integer : outputList){
            System.out.println(integer);
        }
    }
}
class Solution {
    public static ArrayList<Integer> nums  ;
    public  int GetSpecNum(int index){
        nums = new ArrayList<>();
        for(int i = 1 ; i  <= index * 3; i++){
            if(isSpecNum(i)){
                nums.add(i);
            }
        }
        return nums.get(index-1) ;
    }
    public static boolean isSpecNum(int num){
        while(num != 1){
            if (num % 2 == 0){
                num /= 2 ;
                continue;
            }
            if(num % 3 == 0){
                num /= 3 ;
                continue;
            }
            if(num % 7 == 0){
                num /= 7 ;
                continue;
            }
            break ;
        }
        if(num == 1){
            return true ;
        }
        return false ;
    }
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder() ;
        char[] chars  = new char[]{'I','V','X','L','C','D','M'};
        int[] ints = new int[]{1,5,10,50,100,500,1000};
        int[] digits = new int[chars.length];
        for(int i = chars.length - 1 ; i >= 0 ; i--){
            digits[i] = num / ints[i] ;
            num %= ints[i] ;
        }
        for(int k = ints.length -1 ; k >= 0 ; k--){
            if(digits[k] == 1 && digits[k-1] == 4 && k >= 1){
                ans.append(chars[k-1]);
                ans.append(chars[k+1]);
            }else if(digits[k] == 4){
                ans.append(chars[k]);
                ans.append(chars[k+1]);
            }else{
                for(int l = 0 ; l  < digits.length ; l++){
                    ans.append(chars[k]);
                }
            }
        }
        return ans.toString() ;
    }
}