import java.util.*;
class Solution {
    public int lastStoneWeight(int[] stones) {
        //create a max heap
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        //add element into heap
        for (int s: stones) {
            q.add(s);
        }
        
        while(q.size()>1) {
            int x = q.poll();
            int y = q.poll();
            
            if (x != y) {
                q.add(Math.abs(x-y));
            }
            
        }
        
        //check q.size
        if (q.size()==1) {
            return q.poll();
        } else {
            return 0;
        }
        

        
    }
}
