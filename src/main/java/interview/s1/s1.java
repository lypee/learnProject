package interview.s1;

import java.util.HashMap;

public class s1 {
}
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer , Integer> hashMap = new HashMap<>() ;
        for(Integer integer : nums){
            if(hashMap.containsKey(integer)){
                return true ;
            }else{
                hashMap.put(integer, 1);
            }
        }
        return false ;
    }
}