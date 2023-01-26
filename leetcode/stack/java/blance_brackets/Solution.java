import java.util.*;
class Solution {

    public static void main(String[] args) {
        String s =   "{{[[(())]]}}";
        if (Solution.isBalanced(s)) {
            System.out.println("balanced");
        } else {
            System.out.println("not balanced");
        }
    }
   public static  boolean isBalanced(String s) {
        // Write your code here
        Stack<Character> st = new Stack<Character>();
        
        for (char c: s.toCharArray()) {
          
          if (c == '(' || c=='[' || c=='{') {
            st.add(c);
          } else {
            if (st.isEmpty()) {
              return false;
            }

            //compare to see if match
            if (c==')' && st.peek() != '(') {
                return false;
            }

            if (c==']' && st.peek() != '[') {
                return false;
            }

            if (c=='}' && st.peek() != '{') {
                return false;
            }
            
            
            st.pop();
            
          }
          
          
        }
        
        return st.isEmpty();
        
      }






}
