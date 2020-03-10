package tmp.StringToInteger;


import ch.qos.logback.core.pattern.color.ANSIConstants;

import java.math.BigDecimal;
import java.math.BigInteger;

public class StringToString {
    public static void main(String[] args){
        String s = "   -9 " ;
        // min:-2147483648 max 2147483647
        try{
            int ans = StringToInt(s) ;
           System.out.println(ans);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static int StringToInt(String str) throws Exception {
        if(str == null  ){
            throw new Exception("字符串为null") ;
        }
        str = str.trim();
        if(str.length() < 1){
            throw new Exception("字符串长度不够");
        }
        boolean flag = true ;
        if(str.charAt(0) == '-' && str.length() > 1 ){
            //标志为负数
            flag = false ;
            str = str.substring(1) ;
        }
        char[] chars = str.toCharArray() ;
        BigDecimal ansInt = new BigDecimal(0) ;
        for(int i = 0 ; i< chars.length ; i++) {
            if(!isDigit(chars[i])){
                throw new Exception("非法字符串");
            }
            int tmpInt = chars[i] - '0' ;
                ansInt = ansInt.multiply(new BigDecimal(10)) ;
                ansInt = ansInt.add(new BigDecimal(tmpInt));
                System.out.println(ansInt);
            }
        if(!flag){
            ansInt = ansInt.negate() ;
        }
        if(flag && ansInt.compareTo(new BigDecimal(Integer.MAX_VALUE)) == 1 ||
                (!flag && ansInt.compareTo(new BigDecimal(Integer.MIN_VALUE)) == -1)){
            throw new Exception("字符串对应整数产生溢出") ;
        }
        return ansInt.intValue() ;
    }
    public static boolean isDigit(Character c){
        if(c == null){
            return false ;
        }
        int chr = (int)c ;
        return (chr >= 48 && chr <= 57) ;
    }

}
