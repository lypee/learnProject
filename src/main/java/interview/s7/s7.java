//package interview.s7;
//
//import java.util.Stack;
//
//public class s7 {
//}
//class Solution {
//
//    public int calculate(String s) {
//        StringBuilder stringBuilder = new StringBuilder();
//        Stack<Character> symbols = new Stack<>() ;
//        Stack<Character> numbers = new Stack<>() ;
//        char[] chars = s.toCharArray() ;
//        for(int i = 0 ; i < chars.length; i++){
//          switch (chars[i]){
//              case '(': {
//                  symbols.push(chars[i]);
//              }
//              case ')':{
//                  while(symbols.peek() != '('){
//                      stringBuilder.append(symbols.pop());
//                  }
//              }
//              default: {
//                  symbols.push(chars[i]);
//              }
//          }
//        }
//    }
//    public int calutor(String string){
//
//    }
//}