import java.math.BigInteger;
class Solution {
    public int countGoodNumbers(long n) {
        int m = 1000000007;
        
        //find number of odd and even
        long odd = n/2;
        long even = n - odd;
        
        //do cal using BigInteger
        BigInteger evenNumber = cal(5, even, m);
        BigInteger oddNumber = cal(4, odd, m);
        
        //multiply
        BigInteger result = evenNumber.multiply(oddNumber);
        
        //mod again
        BigInteger modBig = new BigInteger(String.valueOf(m));
        BigInteger ans = result.mod(modBig);
        
        return ans.intValue();
        
    }
    
    public BigInteger cal(int base, long power, long mod) {
        BigInteger baseBig = new BigInteger(String.valueOf(base));
        
        BigInteger powerBig = new BigInteger(String.valueOf(power));
        
        BigInteger modBig = new BigInteger(String.valueOf(mod));
        
        return baseBig.modPow(powerBig, modBig);
    }
    
    
}
