package interview.s4;

public class s4 {
    public static void main(String[] args){
        System.out.println(new Solution().reverse(123));
    }
}
class Solution {
    public int reverse(int x) {
        if(x == 0){
            return 0 ;
        }
        boolean flag = false ;
        if(x < 0){
            x = Math.abs(x);
            flag = true ;
        }
        int tmp = x  ;
        int digit = 0 ;
        StringBuffer stringBuffer = new StringBuffer();
        if(flag){
            stringBuffer.append("-");
        }
        while(tmp !=  0){
            int tmpChar = tmp  %  10 ;
            stringBuffer.append(tmpChar);
            tmp /= 10 ;
        }
        try{
           return  Integer.valueOf(stringBuffer.toString());
        }catch (Exception e){
            return 0;
        }finally {
            return Integer.valueOf(stringBuffer.toString()) ;
        }
    }
}