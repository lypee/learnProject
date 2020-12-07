package collections.s349;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class s349 {
}
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer ,Integer> hashMap = new HashMap<>() ;
        for(Integer integer : nums1){
            hashMap.put(integer , 1);
        }
        for(Integer integer : nums2){
            if(hashMap.containsKey(integer)){
                hashMap.put(integer , 2);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>() ;
        for(Map.Entry<Integer , Integer> entry : hashMap.entrySet()){
            if(entry.getValue() > 1 ){
                ans.add(entry.getKey());
            }
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }

}
