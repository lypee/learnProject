package learn.Interview;

public class Interview {
    public static void main(String[] args){

    }
    public static int stair(int n){
        if(n <= 0){
            return 0 ;
        }
        int[] dp = new int[n+1] ;
        dp[0] = 0 ;
        dp[1] = 1 ;
        dp[2] = 2 ;
        dp[3] = 3 ;
        for(int i = 4 ; i <= n ; i++){
            dp[i] = dp[i-1] + dp[i-2] ;
        }
        return dp[n];
    }

}
