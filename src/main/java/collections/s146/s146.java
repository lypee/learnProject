package collections.s146;

import java.util.HashMap;
import java.util.LinkedList;

public class s146 {
}
class LRUCache {
    public HashMap<Integer ,Node> hashMap  ;
    public LinkedList<Node> list ;
    public int cap ;
    public LRUCache(int capacity) {
        hashMap = new HashMap<>(capacity) ;
        list = new LinkedList<>() ;
        this.cap = capacity ;
    }

    public int get(int key) {
        if (!hashMap.containsKey(key)){
            return -1 ;
        }
        Node node = hashMap.get(key) ;
        put(key , node.val);
        return node.val ;
    }

    public void put(int key, int value) {
        Node node = new Node(key , value) ;
        if(!hashMap.containsKey(key)){
            if(hashMap.size() == cap){
                Node oldNode = list.removeLast() ;
                hashMap.remove(oldNode.key);
            }
            hashMap.put(key , node) ;
            list.addFirst(node);
        }else{
            list.remove(hashMap.get(key)) ;
            hashMap.put(key , node) ;
            list.addFirst(node);
        }
    }
    static class Node{
        public int key , val ;
        public Node pre , next ;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
