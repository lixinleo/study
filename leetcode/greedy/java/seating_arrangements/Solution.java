import java.util.*;
public class Solution {

    public static void main(String[] args) {
        int[] arr = {5, 10, 6,8};

        Solution s = new Solution();

        int ans = s.minOverallAwkwardness(arr);

        System.out.println(ans);

    }

    int minOverallAwkwardness(int[] arr) {
    // Write your code here
    Arrays.sort(arr);

    //for the first two
    int ans = arr[1] - arr[0];
    int n = arr.length;

    //special case for the last two n-1, n-2
    if ((arr[n-1] - arr[n-2])>ans) {
      ans = arr[n-1] - arr[n-2];
    }

    //cal 0, 2, 4, 6
    int pre = arr[0];
    int diff = 0;
    for(int i=2; i<n; i++) {
      if (i%2 !=0) {
        continue;
      }

      diff = arr[i] - pre;
      if (diff > ans) {
        ans = diff;
      }

      pre = arr[i];

    }

    //cal 0,1,3,5
    pre = arr[0];
    diff = 0;

    for (int i=1; i<n; i++) {
      if (i%2==0) {
        continue;
      }

      diff = arr[i] - pre;

      if (diff>ans) {
        ans = diff;
      }

      pre = arr[i];


    }

    return ans;

  }
}
