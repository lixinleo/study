class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        //use dp. use two dimension array
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1+1][n2+1];
        
        //fill dp
        
        for (int i=1; i<=n1; i++) {
            for (int j=1; j<=n2; j++) {
                if (nums2[j-1] == nums1[i-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
            }
        }
        
        int ans = 0;
        for (int i=0; i<=n1; i++) {
            for (int j=0; j<=n2; j++) {
                ans = Math.max(ans, dp[i][j]);
               // System.out.println(dp[i][j]);
            }
        }
        
        return ans;
        
    }
}
