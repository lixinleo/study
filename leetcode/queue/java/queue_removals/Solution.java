import java.util.*;

public class Solution {

    int[] findPositions(int[] arr, int x) {
        // Write your code here
        Queue<Integer> q = new LinkedList<Integer>();
        
        for (int i=0; i<arr.length; i++) {
          q.add(i);
        }
        
        int[] ans = new int[x];
        
        int count =0;
        
        while (count < x) {
          //step one. pop x element
          ArrayList<Integer> removed = new ArrayList<Integer>();
          int maxIndex = -1;
          int maxV = -1;
          
          int rcount =0;
          while (!q.isEmpty() && rcount < x) {
            //index removed as r
            int r = q.remove();
            removed.add(r);
            
            if (arr[r] > maxV) {
              maxV = arr[r];
              maxIndex = r;
            }
            
            rcount++;
            
          }
          
          //step two:
          ans[count] = maxIndex+1;
          
          for (int i: removed) {
            if (i== maxIndex) {
              continue;
            }
            
            if (arr[i] >0) {
              arr[i] = arr[i] -1;
            }
            
            q.add(i);
          }
          
          
          count++;
        }
        
        return ans;
        
        
        
      }

}

