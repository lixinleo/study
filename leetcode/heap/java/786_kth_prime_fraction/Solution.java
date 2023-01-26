import java.util.*;
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        PriorityQueue<Element> q = new PriorityQueue<>(new Comparator<Element>() {
            
            public int compare(Element e1, Element e2) {
              
                if (e1.first * e2.last > e1.last * e2.first) {
                    return -1;
                } else {
                    return 1;
                }
                
                
            }
            
        });
        
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (q.size()<k) {
                    q.add(new Element(arr[i], arr[j]));
                } else {
                    Element e1 = q.peek();
                    Element e2 = new Element(arr[i], arr[j]);
                    
                     if (e1.first * e2.last > e1.last * e2.first) {
                         q.poll();
                         q.add(e2);
                     }
             
                    
                }
            }
        }
        
        Element e = q.peek();
        
        int[] ans = new int[2];
        ans[0] = e.first;
        ans[1] = e.last;
        
        
        return ans;
        
        
    }
}

class Element {
    public int first;
    public int last;
    
    public Element(int first, int last) {
        this.first = first;
        this.last = last;
    }
}
