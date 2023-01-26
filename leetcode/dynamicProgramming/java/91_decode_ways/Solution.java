class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) =='0') {
            return 0;
        }
        
        //use dynamic programing. result in dp[n]
        int n = s.length();
        int[] dp = new int[n+1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i=2; i<=n; i++) {
            
            //fill dp. current char is at i-1. It is because dp[n] == for the last digit
            char cur = s.charAt(i-1);
            
            if (cur == '0') {
                //have to combine with the previous char to make it possible
                char pre = s.charAt(i-2);
               // System.out.println(pre);
                
                //if previous is only can be 1 or 2
                if (pre != '1' && pre !='2') {
                    return 0;
                } else {
                    dp[i] = dp[i-2];
                }
                
                continue;
            }
            
            //if previous is 0
            if (s.charAt(i-2) =='0') {
                //we have not choice. can not combine with the previous one
                dp[i] = dp[i-1];
                continue;
            }
            
            //see if we can combine with the previous one. 11 to 26 is good
            String nowAndPre = s.substring(i-2, i);
            
            if (Integer.valueOf(nowAndPre) <=26) {
            
                dp[i] =dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i-1];
            }
        }
   
        return dp[n];
        
     
    }
}
