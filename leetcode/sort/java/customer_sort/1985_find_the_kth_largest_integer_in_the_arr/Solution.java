import java.util.*;
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        
       Arrays.sort(nums, new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                   return o1.compareTo(o2);
                
                } else {
                    
                    if (o1.length() > o2.length()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });
        
        return nums[nums.length -k];

    }
}
