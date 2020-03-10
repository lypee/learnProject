package collections.s122;

public class s122 {
}
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0 ;
        int diff = 0 ;
        for(int index = 1 ; index < prices.length   ; index++){
            diff = prices[index]  - prices[index-1] ;
            if(diff > 0){
                ans += diff ;
            }
        }
        return ans ;
    }
}
