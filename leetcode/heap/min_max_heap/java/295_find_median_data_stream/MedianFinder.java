import java.util.*;
class MedianFinder {
     private PriorityQueue<Integer> maxh;
     private PriorityQueue<Integer> minh;
     int count;

    /** initialize your data structure here. */
    public MedianFinder() {
        maxh = new PriorityQueue<Integer>(Collections.reverseOrder());
        minh = new PriorityQueue<Integer>();
        count = 0;
        
    }
    
    public void addNum(int num) {

        count++;
        
        //if only one element, add to max heap
        if (count==1) {
            maxh.add(num);
           
        } else {
        
            //if two elements. smaller to max heap and bigger to min heap
            if (count == 2) {
                
                int e1 = maxh.poll();
                if (e1 < num) {
                    
                    maxh.add(e1);
                    minh.add(num);
                } else {
                    
                   maxh.add(num);
                    minh.add(e1);
                }
             
            } else {
                //more than 2 element.
                //step 1: if smaller than max heap, to max heap. Otherwise, to min heap
                if (num < maxh.peek()) {
                    maxh.add(num);
                } else {
                    minh.add(num);
                }

                //step 2: balance heaps. if more than 2 diff, adjust it
                int diff = Math.abs(minh.size() - maxh.size());

                if (diff >=2) {
                    if (minh.size() > maxh.size()) {
                        maxh.add(minh.poll());
                    } else {
                        minh.add(maxh.poll());
                    }
                }
            
            }
            
        }
        
    }
    
    public double findMedian() {
        double ans;
       
        if (minh.size() == maxh.size()) {
           
            ans = (double)(minh.peek() + maxh.peek())/2;
        } else {
            if (minh.size() > maxh.size()) {
                ans = (double)minh.peek();
            } else {
                ans = (double)maxh.peek();
            }
        }
        
        return ans;
        
    }
}
