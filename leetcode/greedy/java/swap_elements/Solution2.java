import java.util.*;
public class Solution2 {

    public static void main(String[] args) {
        int[] arr = {8,9,11,2,1};
        int k = 3;

        int[] ans = Solution2.swapElements(arr, k);

        for (int n: ans) {
            System.out.println(n);
        }
    }
    public static int[] swapElements(int[] arr, int k) {
        
        for (int i=0; i<arr.length; i++) {
            if (k<=0) {
                break;
            }

            //find possible smallest number to swap

            //this is pos which we need to swap with i. After loop, if it is still i, we do not find.
            int pos = i;

            for (int j=i+1; j<arr.length; j++) {
                //we do not have enough swaps, so stop
                if (j-i>k) {
                    break;
                }
                if (arr[j] < arr[pos] ) {
                    //update pos. Also we compare with arr[pos]. If we find smaller, pos will be updated
                    pos = j;
                }
            }

            //we find some pos to swap, so do swap now
            if (pos >i) {
            
                int temp = arr[pos];

                for(int h=pos; h>i; h--) {
                    arr[h] = arr[h-1];
                }

                arr[i] =temp;
                k = k -(pos-i);

            }
        }
        return arr;
    }
}
