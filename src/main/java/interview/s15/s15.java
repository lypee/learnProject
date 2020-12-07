package interview.s15;

import java.util.LinkedList;
import java.util.Queue;

public class s15 {
}
class Solution {
    public boolean isValid(String s) {
        Queue<Character> queue = new LinkedList<>() ;
        for(Character c : s.toCharArray()){
            queue.offer(c) ;
        }
        return false ;
    }
}