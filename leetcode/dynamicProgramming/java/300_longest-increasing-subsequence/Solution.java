class Solution {
    public int lengthOfLIS(int[] nums) {
        //use DP. dp to store max sequence at that index. we start from end
        int[] dp = new int[nums.length];
        
        for (int i=nums.length-1; i>=0; i--) {
            //always be 1 because we can start by itself
            int val =1;
            int ele = nums[i];
            for (int j=i+1; j<nums.length; j++) {
               // System.out.println("inside");
                //will try to find element which is strictly bigger than ele, and check dp
                if (nums[j] > ele) {
                    val = Math.max(val, 1+ dp[j]);
                }
                
            }
            
            dp[i] = val;
        }
        
        int ans = 0;
        for (int n: dp) {
            ans = Math.max(ans, n);
        }
        
        return ans;
        
    }
}
