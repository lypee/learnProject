package collections.s14;

public class s14 {
}
class Solution {
    public String longestCommonPrefix_2(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }
    public String longestCommonPrefix(String[] strs){
        if(strs.length < 1){
            return null ;
        }
        String str = strs[0] ;
        for(int i = 1 ; i < strs.length ; i++){
            int j = 0 ;
            for( ; j < str.length() && j < strs[i].length() ;j++){
                if(str.charAt(j) != strs[i].length()){
                    break ;
                }
                str = str.substring(0 ,j);
                if(str.equals("")){
                    return str ;
                }
            }

        }
        return str ;
    }
}

