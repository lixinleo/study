import java.util.*;
// Add any extra import statements you may need here


class Main {
  // Add any helper functions you may need here
  
  
  boolean isBalanced(String s) {
    // Write your code here
    Stack<Character> st = new Stack<>();

    if (s.length()==0) {
        return true;
    }

    for (int i=0; i< s.length(); i++) {
        char c = s.charAt(i);

        if (c ==')' || c== ']' || c=='}') {
            if (st.isEmpty()) {
                return false;
            }

            char d = st.pop();
            
            if (c==')' && d != '(') {
                return false;
            }

            if (c==']' && d!='[') {
                return false;
            }

            if (c=='}' && d!='{') {
                return false;
            }

        } else {
            st.push(c);
        }
    }

    return st.isEmpty();
    
  }












  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;
  void check(boolean expected, boolean output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      System.out.print(expected); 
      System.out.print(" Your output: ");
      System.out.print(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printString(String str) {
    System.out.print("[" + str + "]");
  }
  
  public void run() {
    String s_1 = "{[(])}";
    boolean expected_1 = false;
    boolean output_1 = isBalanced(s_1);
    check(expected_1, output_1);

    String s_2 = "{{[[(())]]}}";
    boolean expected_2 = true;
    boolean output_2 = isBalanced(s_2);
    check(expected_2, output_2);

    // Add your own test cases here
        
  }
  
  public static void main(String[] args) {
    new Main().run();
  }
}
