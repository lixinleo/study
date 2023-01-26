import java.util.*;
public class Solution {

    public static void main(String[] args) {
        int[] arr = {8,9,11,2,1};
        int k = 2;

        int[] ans = Solution.swapElements(arr, k);

        for (int n: ans) {
            System.out.println(n);
        }
    }
    public static int[] swapElements(int[] arr, int k) {
        //special case
        if (arr.length ==1) {
            return arr;
        }

        //swap count left
        int left = k;

        //copy to number
        int[] nums = new int[arr.length];

        for (int j=0; j<arr.length; j++) {
            nums[j] = arr[j];
        }

        Arrays.sort(nums);

        //this is index to move from
        int moveIndex;


        //loop from pos 0 to last index in arr
        for (int pos=0; pos < arr.length; pos++) {
            moveIndex = 0;

            //value of postion to move
            int posVal = arr[pos];

            for (int i=0; i<nums.length; i++) {
                if (nums[i] == -1) {
                    continue;
                }

                //if num is bigger than pos val, we do not need to continue because array is sorted
                if (nums[i] > posVal) {
                    break;
                }

                //if we find value and can move(enough k), get move index. Also make value to be -1, so we skip it the next time
                for (int j=pos+1; (j<pos+left+2) && j<arr.length; j++) {
                    if (arr[j] == nums[i] && (j-pos)<= left) {
                        moveIndex = j;
                        nums[i] = -1;
                        break;

                    }
                }
            }

            if (moveIndex ==0) {
                continue;
            }

            
            int temp = arr[moveIndex];

            for (int h=moveIndex;  h>pos; h--) {
                arr[h] = arr[h-1];
            }
            arr[pos] = temp; 

            //update parameter
            left = left - (moveIndex-pos);

        }

        return arr;


    }

}
