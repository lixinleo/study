import java.util.*;
class Solution {
    public String makeGood(String s) {
        Stack<Character> s1 = new Stack<Character>();
        
        //try to delete
        while (true) {
            //flag to see if we have delete action
           boolean hasDelete = false;

            for(int i=s.length()-1; i>=0; i--) {
                char c= s.charAt(i);
                if (!s1.isEmpty() && s1.peek() != c && Character.toLowerCase(c) == Character.toLowerCase(s1.peek())) {
                    s1.pop();
                    //set flag true
                    hasDelete = true;
                } else {
                    s1.push(c);
                }

            }

            //build new string after one delete
            s = "";
            while (!s1.isEmpty()) {
                s = s + s1.pop();
            }
            
            if (!hasDelete) {
                break;
            }
        }
        
        return s;
        
        
    }
}
