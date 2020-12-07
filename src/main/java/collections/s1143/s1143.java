package collections.s1143;

public class s1143 {
    public static void main(String[] args){
        String s1 = "abcbcsfadasafvcc" ;
        String s2 ="sfads" ;
        System.out.println(new Solution().longestCommonSubsequence(s1 ,s2));
    }
}
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length() ;
        int length2 = text2.length() ;
        int ans = 0 ;
        if(length1 == 0 || length2 == 0){
            return 0 ;
        }
        int[][] dp = new int[length1][length2] ;
        for(int i = 0 ; i < length1 ;i++){
            for(int j = 0 ; j < length2 ;j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1 ;
                }
                if(i > 0 && j > 0){
                    dp[i][j] = Math.max(dp[i][j] , dp[i-1][j-1]+dp[i][j]);
                    ans = Math.max(dp[i][j] , ans);
                }
            }
        }
        return ans ;
    }
}