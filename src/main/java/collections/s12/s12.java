package collections.s12;

public class s12 {
    public static void main(String[] args){
        System.out.println(new Solution().intToRoman(3451));
    }
}
class Solution {
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