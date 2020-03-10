package collections.s121;

import java.util.Stack;

public class s121 {

}
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 0){
            return 0 ;
        }
        int ans = 0 ;
        Stack<Integer> stack = new Stack<Integer>() ;
        for(int index = prices.length - 1 ; index >= 0 ; index--){
            if(stack.isEmpty()){
                stack.push(prices[index]) ;
            }
            if(prices[index] > stack.peek()){
                stack.push(prices[index]) ;
            }
            ans = Math.max(ans , stack.peek() - prices[index]) ;
        }
        return ans ;
    }
}