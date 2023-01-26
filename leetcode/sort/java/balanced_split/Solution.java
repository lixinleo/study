import java.util.*;

public class Solution{

    public static void main(String[] args) {
        int[] arr = {3,6,3,4,4};
        boolean result = balancedSplit(arr);
        System.out.println(result);
    }

    public static boolean balancedSplit(int[] arr) {
        Arrays.sort(arr);

        int sum = 0;

        for(int n: arr) {
            sum = sum +n;
        }

        int subSum = 0;

        for (int i=0; i<arr.length; i++) {
            subSum = subSum + arr[i];

            if (subSum == sum - subSum) {
                if (arr[i] != arr[i+1]) {
                    return true;
                }
            }
        }

        return false;


    }
}
