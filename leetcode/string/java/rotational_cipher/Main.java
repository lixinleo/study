import java.util.*;
// Add any extra import statements you may need here


class Main {

  // Add any helper functions you may need here
  

  String rotationalCipher(String input, int rotationFactor) {
    // Write your code here

    //create a array of "a to z";
    char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    String ans = "";

    for (int i=0; i<input.length(); i++) {
        char c = input.charAt(i);

        //check if this char is digit
        if (Character.isDigit(c)) {

            //char to integer
            int k = Character.getNumericValue(c);
            ans = ans + (k+rotationFactor)%10;

        //check if this char is letter
        } else if (Character.isLetter(c)) {
            //char to String
            String s = "" +c;

            //String to lower case
            String sl = s.toLowerCase();

            boolean isLower = false;

            //string compare
            if (s.toLowerCase().equals(s)) {
                isLower = true;
            }

            int index = 0;

            //string to char
            char lc = sl.charAt(0);

            for (int k=0; k<letters.length; k++) {
                if (lc==letters[k]) {
                    index =k;
                    break;
                }
            }

            char cnew = letters[(index+rotationFactor)%26];

            if (!isLower) {
                ans = ans + (""+cnew).toUpperCase();
            } else {
                ans = ans+cnew;
            }


        } else {
            ans = ans + c;
        }
    
    }

    return ans;
  }


  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;
  void check(String expected, String output) {
    boolean result = (expected.equals(output));
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printString(expected); 
      System.out.print(" Your output: ");
      printString(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printString(String str) {
    System.out.print("[\"" + str + "\"]");
  }
  
  public void run() {
    String input_1 = "All-convoYs-9-be:Alert1.";
    int rotationFactor_1 = 4;
    String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
    String output_1 = rotationalCipher(input_1, rotationFactor_1);
    check(expected_1, output_1);

    String input_2 = "abcdZXYzxy-999.@";
    int rotationFactor_2 = 200;
    String expected_2 = "stuvRPQrpq-999.@";
    String output_2 = rotationalCipher(input_2, rotationFactor_2);
    check(expected_2, output_2);

    // Add your own test cases here
    
  }
  
  public static void main(String[] args) {
    new Main().run();
  }
}
