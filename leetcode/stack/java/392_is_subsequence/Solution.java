import java.util.*;
class Solution {
    public boolean isSubsequence(String s, String t) {
        Stack<Character> st = new Stack<Character>();
        
        //put chars of t into stack
        for (int i = t.length()-1; i>=0; i--) {
            st.push(t.charAt(i));
        }
        
        //index for s
        int index = 0;
        
        while (!st.isEmpty()) {
            char fromT = st.pop();
            if (index <= s.length()-1 && s.charAt(index) == fromT) {
                index = index+1;
            }
        }
        
        if (index >= s.length()) {
            return true;
        } else {
            return false;
        }
        
        
    }
}
