package collections.s84;

import java.util.HashSet;

public class s84 {
    public static int a = 10 ;
    public static void main(String[] args){

        String s = "asda";
       print1(s);
        myPrint(a ,s );
        System.out.println("a: "+ a);
    }
    public static void myPrint(int a, String b){
        System.out.println("this is my print  " + b);
        print1(b);
    }

    public static void print1(String b){
        System.out.println("this is " + b);
    }

}
class Solution {
    public int ans = 0 ;
    public int largestRectangleArea(int[] heights) {
        HashSet<Integer> hashSet = new HashSet<>() ;
        for(Integer integer : heights){
            hashSet.add(integer) ;
        }
        for(Integer integer : hashSet){
            if(!hashSet.contains(integer-1)){
                int curNum = integer ;
                int curAns = 1 ;
                while(hashSet.contains(curNum+ 1)){
                    curAns++ ;
                   curNum++ ;
                }
                ans = Math.max(curAns , ans) ;
            }
        }
        return ans ;
    }
}