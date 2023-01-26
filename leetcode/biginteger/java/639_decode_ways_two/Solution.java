import java.math.BigInteger;
class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        
     
        int mod = 1000000007;
        
        //use dp. dp[n] is ways of string with length of n
        int n = s.length();
        int[] dp = new int[n+1];
        
        //zero length is 1.  we need this one
        dp[0] = 1;
        
        //fill dp[1]
        if (s.charAt(0) == '*') {
            dp[1] = 9;
        } else {
            dp[1] =1;
        }
        
        //try to fill dp
        for (int i=2; i<=n; i++) {
            //current char is at i-1
            char cur = s.charAt(i-1);
            
            char pre = s.charAt(i-2);
            
            dp[i-1] = dp[i-1]%mod;
            dp[i-2] = dp[i-2]%mod;
            
            if (cur=='0') {
                
                if (pre !='1' && pre !='2' && pre !='*') {
                    return 0;
                }
                
                if (pre =='1' || pre=='2') {
                    dp[i] = dp[i-2]%mod;
                } else {
                    //pre is *
                    dp[i] = (dp[i-2]*2)%mod;
                  
                }
                
             
                
            } else if (cur =='*') {
                
                
                if (pre=='1') {
                    dp[i] = (mul(dp[i-2] ,9)+ mul(dp[i-1],9))%mod;
                } else if (pre=='2') {
                    dp[i] =  (mul(dp[i-2],6) + mul(dp[i-1],9))%mod;
                } else if (pre=='*') {
                    //here is complicated one. cur is * and prev is *
                    dp[i] = (mul(dp[i-1],9)+ mul(15 , dp[i-2]))%mod;
                    
               
                 
                } else {
                  
                    dp[i] = mul(dp[i-1] ,9)%mod;
                }
            } else {
                //handle that current char is not *
                if (pre == '1') {
                    dp[i] = (dp[i-1] + dp[i-2])%mod;
                    
                } else if (pre=='2') {
                    int curVal = Integer.valueOf(cur+ "");
                   
                    if (curVal>6) {
                        dp[i] = dp[i-1]%mod;
                    } else {
                      dp[i] = (dp[i-1] + dp[i-2])%mod;  
                    }
                    
                } else if (pre == '*') {
                    int curVal = Integer.valueOf(cur+ "");
                    
                    if (curVal>6) {
                        dp[i] = (dp[i-1] + dp[i-2])%mod;
                    } else {
                        dp[i] = (dp[i-1] + mul(dp[i-2],2))%mod;
                    }
                    
                } else {
                    dp[i] = dp[i-1]%mod;
                }
                
                
            }
        }
        
        return dp[n]%1000000007;
        
    }
    
    public int mul(int a, int b) {
        BigInteger m = new BigInteger(String.valueOf(a));
        
        BigInteger n = new BigInteger(String.valueOf(b));
        
        BigInteger mod = new BigInteger(String.valueOf("1000000007"));
        
        BigInteger result = m.multiply(n);
        result = result.mod(mod);
        
        return result.intValue();
        
    }
    
    
}
