package collections.s7;

public class s7 {
}
class Solution {
    public int reverse(int x) {
        boolean flag = false ;
        if(x < 0){
            x = Math.abs(x);
            flag = true ;
        }
        int ans = 0 ;
        while (x != 0) {
            if(ans * 10 / 10 != ans){
                return 0 ;
            }
            ans = ans * 10 + x % 10 ;;
            x /= 10 ;
        }

        return flag ? -ans : ans ;
    }
}