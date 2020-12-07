package collections.s3;

import java.util.HashMap;

public class s3 {
}
//class Solution {
//    public int lengthOfLongestSubstring(String s) {
//        HashMap<Character , Integer> hashMap = new HashMap<>() ;
//        int ans = 0 ;
//        for(int i =  0 ,j = 0 ; j < s.length() ; j++){
//            if(hashMap.containsKey(s.charAt(j))){
//                i = Math.max(hashMap.get(s.charAt(j)) , i) ;
//            }
//            ans = Math.max(ans , j-i+1);
//            hashMap.put(s.charAt(j), j+1) ;
//        }
//        return ans ;
//    }
//}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character , Integer >hashMap = new HashMap<>() ;
        int left  = 0 ;
        int ans = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            if (hashMap.containsKey(s.charAt(i))) {
                left = Math.max(left, hashMap.get(s.charAt(i)) +1 );
            }
            hashMap.put(s.charAt(i) , i )  ;
            ans  = Math.max(ans , i - left +1 ) ;
        }
        return ans ;
    }
}