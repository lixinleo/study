import java.util.*;
public class Solution {

    public static void main(String[] args) {
        int[] arr = {2, 1};

        int[] result = findSignatureCounts(arr);
        for (int c: result) {
            System.out.println(c);
        }
    }

    public static int[] findSignatureCounts(int[] arr) {
        // Write your code here
        int n = arr.length;
        
        int [] yearBook = new int[n];
        int [] ans = new int[n];

        //use hashmap to remember number of signature
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        
        for (int i=0; i<n; i++) {
          yearBook[i] = arr[i];
          count.put(arr[i], 1);
          
        }
        
        //do the first round
        int[] tempY = new int[n];
        for (int i=0; i<n; i++) {
          tempY[i] = yearBook[i];
        }
        
        //after remember year book, we do the exchange
        int student;
        for (int i=0; i<n; i++) {
          yearBook[arr[i] -1] = tempY[i];
        }

        while (true) {
          boolean done = true;  
          //check to see if every one is holding own's
          for (int i=0; i<arr.length; i++) {
            if (yearBook[i] != arr[i]) {
              done = false;
              break;
            }
            
          }
          
          //if we are done, break loop
          if (done) {
            break;
          }
          
          //let us do sign again. copy to tempY again
          for (int i=0; i<n; i++) {
            tempY[i] = yearBook[i];
          }
          
          //do sign
          for (int i=0; i<n; i++) {
            if (arr[i] == tempY[i]) {
              continue;
            }
            
            //not equal, sign
            count.put(tempY[i], count.get(tempY[i]) +1);
            yearBook[arr[i]-1] = tempY[i];
            
          }
          
        }
        
        for (int i=0; i<arr.length; i++) {
          ans[i] = count.get(arr[i]);
        }
        
        return ans;
        
      }
    }
