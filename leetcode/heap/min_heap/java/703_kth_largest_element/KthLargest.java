import java.util.*;
class KthLargest {
    
    private int k;
    private PriorityQueue<Integer> heap = new PriorityQueue<Integer> ();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        
        for(int n: nums) {
            add(n);
        }
     
        
    }
    
    public int add(int val) {
        
        if (heap.size() < k) {
            heap.offer(val);
        } else {
            //if we have enough element, only add one which is larger than smallest.
            //if it is smaller than smallest, will not affect the result and we do nothing
            //before add new one, remove the smallest one. Therefore, we keep the k elements in heap.
            if (val > heap.peek()) {
              
                heap.poll();
                heap.add(val);
              
            }
        }
        
        return heap.peek();
    }
}
