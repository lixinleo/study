import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here


class Main {

  // Add any helper functions you may need here
  boolean reachLimit(float[] growthRates, int days) {
      int count = 1;

      int goal = 1000000000;

      while (count<= days) {
          int t = 0;
          for (float f: growthRates) {
              t = t+ (int)Math.pow(f, count);
          }

          if (t>goal) {
              return true;
          }
          count++;
      }

      return false;

  }
  

  int getBillionUsersDay(float[] growthRates) {
    // Write your code here
    int low =1;
    int high = Integer.MAX_VALUE;
    int mid = 0;

    while (low <= high) {
        //l + (h-l)/2 for larger number
        mid = (int)((low+high)/2);


        if (reachLimit(growthRates, mid)) {
            high = mid -1;
        } else {
            low = mid +1;
        }
    }

    int ans = Math.min(low, high);

    if (reachLimit(growthRates, ans)) {
        return ans;
    } else {
        return Math.max(low, high);
    }
    
  }












  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;
  
  void check(int expected, int output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printInteger(expected); 
      System.out.print(" Your output: ");
      printInteger(output);
      System.out.println();
    }
    test_case_number++;
  }
  
  void printInteger(int n) {
    System.out.print("[" + n + "]");
  }
  
  public void run() {
    float[] test_1 = {1.1f, 1.2f, 1.3f};
    int expected_1 = 79;
    int output_1 = getBillionUsersDay(test_1);
    check(expected_1, output_1);

    float[] test_2 = {1.01f, 1.02f};
    int expected_2 = 1047;
    int output_2 = getBillionUsersDay(test_2);
    check(expected_2, output_2);

    
    // Add your own test cases here
    
  }
  public static void main(String[] args) {
    new Main().run();
  }
}
