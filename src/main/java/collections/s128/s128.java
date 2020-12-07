package collections.s128;

import java.util.HashSet;

public class s128 {
}
class Solution {
    public int ans = 0 ;
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>() ;
        for(Integer integer : nums){
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