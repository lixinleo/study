import java.util.*;
class Solution {
    public String largestNumber(int[] nums) {
        
        Integer[] sorted = new Integer[nums.length];
        
        for (int i=0; i<nums.length; i++) {
            sorted[i] = Integer.valueOf(nums[i]);
        }
        
        Arrays.sort(sorted, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                String s1 = o1.toString();
                String s2 = o2.toString();
                return (s1+s2).compareTo(s2+s1);
            }
        });
        
        
        String ans = "";
        
        for (int i=sorted.length-1; i>=0; i--) {
            ans = ans + sorted[i];
        }
        
        if (ans.charAt(0) != '0') {
            return ans;
        } else {
            return "0";
        }
        
    }
  
}
