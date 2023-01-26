import java.util.*;
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> great = new HashMap<Integer, Integer>();
        Stack<Integer> s = new Stack<Integer>();
        
        for(int n: nums2) {
            while(!s.isEmpty()&& s.peek() < n) {
                great.put(s.pop(), n);
                
            }
            
            s.push(n);
        }
        
        for (int i=0; i<nums1.length; i++) {
            nums1[i] = great.getOrDefault(nums1[i], -1);
        }
        
        return nums1;
        
    }
}
