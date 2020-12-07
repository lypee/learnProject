package interview.s191;

public class s191 {
    public static void main(String[] args){
        System.out.println(16 >>> 1 );
    }
}
class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);

    }
}