package interview.s69;

public class s69 {
}
class Solution {
    public int mySqrt(int x) {
        for(int ans = 0 ; ans <= x/2 ;ans++){
            if(ans *ans  < x && (ans+1)*(ans+1) > x){
                return ans ;
            }
        }
        return 0 ;
    }
}