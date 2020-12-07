package interview.s2;

import java.util.HashMap;

public class s2 {
    public static void main(String[] args){
        System.out.println(new Solution2().intToRoman(3992));
    }
}
class Solution {
    public String intToRoman(int num) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        StringBuilder ans = new StringBuilder();
        while (num > 0) {
            if (num > 1000) {
                int count = num / 1000;
                while (count != 0) {
                    count--;
                    ans.append("M");
                    num -= 1000;
                }
            }
            if (num >= 900) {
                ans.append("CM");
                num -= 900;
            }
            if (num >= 500) {
                ans.append("D");
                num -= 500;
            }
            if (num >= 400) {
                ans.append("CD");
                num -= 400;
            }
            if (num >= 100) {
                int cnt = num / 100;
                for (int i = 0; i < cnt; ++i) {
                    ans.append("C");
                }
                num -= cnt * 100;
            }
            if (num >= 90) {
                ans.append("XC");
                num -= 90;
            }
            if (num >= 50) {
                ans.append("L");
                num -= 50;
            }
            if (num >= 40) {
                ans.append("XL");
                num -= 40;
            }
            if (num >= 10) {
                int cnt = num / 10;
                for (int i = 0; i < cnt; ++i) {
                    ans.append("X");
                }
                num -= cnt * 10;
            }
            if (num >= 9) {
                ans.append("IX");
                num -= 9;
            }
            if (num >= 5) {
                ans.append("V");
                num -= 5;
            }
            if (num >= 4) {
                ans.append("IV");
                num -= 4;
            }
            if (num >= 1) {
                int cnt = num / 1;
                for (int i = 0; i < cnt; ++i) {
                    ans.append("I");
                }
            }
        }
        return ans.toString();
    }
}
class Solution2 {
    public String intToRoman(int num) {
        boolean flag = false;
        StringBuilder ans = new StringBuilder();
        int[] nums = {1, 5, 10, 50, 100, 500, 1000};
        char[] str = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] digitStr = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            digitStr[i] = num / nums[i];
            num %= nums[i];
        }
//        for(int i = nums.length - 1;i>=0;i--){
//            ans.append(digitStr[i]);
//        }
        for (int k = nums.length - 1; k >= 0; k--) {
            if (digitStr[k] == 1 && k >= 1 && digitStr[k - 1] == 4) {
                ans.append(str[k-1]) ;
                ans.append(str[k+1]) ;
                k = k - 1;
            } else if (digitStr[k] == 4) {
                ans.append(str[k]) ;
                ans.append(str[k+1]) ;
            } else {
                for (int l = 0; l < digitStr[k]; l++)
                    ans.append(str[k]);
            }
        }
        return ans.toString() ;
    }
}