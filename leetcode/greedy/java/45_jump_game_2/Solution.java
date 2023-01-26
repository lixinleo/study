class Solution {
    public int jump(int[] nums) {
        int ans = 0;
        int goal = nums.length -1;
        
        if (goal ==0) {
            return 0;
        }
        
        while (true) {
            ans++;
            
            //find min goal in every step
            goal = Solution.minIndex(nums, goal);
            if (goal == 0) {
                break;
            }
            
        }
        
        return ans;
        
    }
    
    //when we have goal, find the min index which can reach the goal.
    //we need this to reset goal
    public static int minIndex(int[] nums, int goal) {
        
        for (int i=0; i<goal; i++) {
            int step = nums[i];
            
            //because we start from 0, the first one will have the min value
            if (step >= goal -i) {
                return i;
            }
        }
        
        return -1;
        
    }
}
