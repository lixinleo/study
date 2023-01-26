import java.util.*;
class Solution2 {
    public String largestNumber(int[] nums) {
        
        Integer[] sorted = new Integer[nums.length];
        
        for (int i=0; i<nums.length; i++) {
            sorted[i] = Integer.valueOf(nums[i]);
        }
        
           Comparator<Integer> myc =  (Integer o1, Integer o2) -> {
		   return (o1.toString() + o2.toString()).compareTo(o2.toString() + o1.toString());
	   };
              
          
        
        Arrays.sort(sorted, myc);
        
        
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
