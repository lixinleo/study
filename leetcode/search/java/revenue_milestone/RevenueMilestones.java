import java.util.*;
// Add any extra import statements you may need here


class RevenueMilestones {

  // Add any helper functions you may need here
  int getDay(HashMap<Integer, Integer> map, int m, int max) {
       int low = 1;
        int high = max;
        int mid = 0;

        while (low<=high) {
            mid = (int)(low+high)/2;

            int sum = map.get(mid);

            if (sum==m) {
                return mid;
            }

            if (sum>m) {
                high = mid-1;
            } else {
                low = mid+1;
            }

        }

        int result = Math.min(low, high);
        if (map.get(result) >= m) {
            return  result;
        } else {
            int ans =  Math.max(low, high);
            
            if (!map.containsKey(ans)) {
                return -1;
            }

            if (map.get(ans)>=m) {
                return ans;
            } else {
                return -1;
            }
        }




  }
  

  int[] getMilestoneDays(int[] revenues, int[] milestones) {
    // Write your code here
    
    //use map to remeber revenue until days
    HashMap<Integer, Integer> map = new HashMap<>();

    int total = 0;

    for(int i=0; i<revenues.length; i++) {
        total = total + revenues[i];
        map.put(i+1, total);
    }

    int[] ans = new int[milestones.length];

    //use binary search
    for (int j=0; j<milestones.length; j++ ) {
        ans[j] = getDay(map, milestones[j], revenues.length);
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
    int revenues_1[] = {100, 200, 300, 400, 500};
    int milestones_1[] = {300, 800, 1000, 1400};
    int expected_1[] = {2, 4, 4, 5};
    int[] output_1 = getMilestoneDays(revenues_1, milestones_1);
    check(expected_1, output_1);
    
    int revenues_2[] = {700, 800, 600, 400, 600, 700};
    int milestones_2[] = {3100, 2200, 800, 2100, 1000};
    int expected_2[] = {5, 4, 2, 3, 2};
    int[] output_2 = getMilestoneDays(revenues_2, milestones_2);
    check(expected_2, output_2);
     
    int revenues_3[] = {700, 800, 600, 400, 600, 700};
    int milestones_3[] = {3100, 2200, 800, 2100, 100000};
    int expected_3[] = {5, 4, 2, 3, -1};
    int[] output_3 = getMilestoneDays(revenues_3, milestones_3);
    check(expected_3, output_3);
  
    // Add your own test cases here
    
  }
  
  public static void main(String[] args) {
    new RevenueMilestones().run();
  }
}
