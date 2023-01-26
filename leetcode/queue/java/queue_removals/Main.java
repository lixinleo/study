import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here


class Main {

  // Add any helper functions you may need here
  

  int[] findPositions(int[] arr, int x) {
      int[] ans = new int[x];

      //store index
      Queue<Integer> q = new LinkedList<>();

      for (int i=0; i<arr.length; i++) {
          q.add(i);
      }

      //go x interations
      for (int count=0; count<x; count++) {
          
          //store pop off index
          ArrayList<Integer> al = new ArrayList<>();
          for (int j=0; j<x; j++) {
              if (!q.isEmpty()) {
                  int r = q.remove();
                  al.add(r);
              }
          }

          int maxIndex =0;
          int max = -1;

          for (int j=0; j<al.size(); j++) {
              if (arr[al.get(j)] > max) {
                  max = arr[al.get(j)];
                  maxIndex = al.get(j);
              }
          }

          ans[count] = maxIndex+1;

          for (int k=0; k<al.size(); k++) {
              int val = al.get(k);
              if (val==maxIndex) {
                  continue;
              }

              if (arr[val] >0 ) {
                  arr[val] = arr[val]-1;
              }

              q.add(val);
          }


      }

      return ans;

  }












  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;
  void check(int[] expected, int[] output) {
    int expected_size = expected.length; 
    int output_size = output.length; 
    boolean result = true; 
    if (expected_size != output_size) {
      result = false;
    }
    for (int i = 0; i < Math.min(expected_size, output_size); i++) {
      result &= (output[i] == expected[i]);
    }
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);  
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printIntegerArray(expected); 
      System.out.print(" Your output: ");
      printIntegerArray(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printIntegerArray(int[] arr) {
    int len = arr.length; 
    System.out.print("[");
    for(int i = 0; i < len; i++) {
      if (i != 0) {
        System.out.print(", ");
      }
      System.out.print(arr[i]);
    }
    System.out.print("]");
  }
  
  public void run() {
    int n_1 = 6;
    int x_1 = 5;
    int[] arr_1 = {1, 2, 2, 3, 4, 5};
    int[] expected_1 = {5, 6, 4, 1, 2 };
    int[] output_1 = findPositions(arr_1, x_1);
    check(expected_1, output_1);
    
    int n_2 = 13;
    int x_2 = 4;
    int[] arr_2 = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
    int[] expected_2 = {2, 5, 10, 13};
    int[] output_2 = findPositions(arr_2, x_2);
    check(expected_2, output_2);
  
    // Add your own test cases here
    
  }
  
  public static void main(String[] args) {
    new Main().run();
  }
}
