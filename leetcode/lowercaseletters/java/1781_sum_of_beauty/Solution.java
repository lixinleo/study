class Solution {
    
    public int beautySum(String s) {
      
        int ans = 0;
        
        for (int i=0; i<s.length(); i++) {
            ans = ans + getB(s, i);
           
        }
        
        return ans;
    }
    
    //because char is 26 lower case, we can us 26 length int array to do map.
    //it is much fast then hashmap
    //this function is to try to find sum of beauty for all substring which start from index i
    public int getB(String s, int i) {
     
        int[] arr = new int[26];
        int ans =0;
        for (int j=i; j<s.length(); j++) {
          
            //a's char value is 97. b is 98 etc
            arr[s.charAt(j) -97] = arr[s.charAt(j) -97] +1;
            
            int min=Integer.MAX_VALUE;
            int max = 0;
            
            for (int n: arr) {
                if (n==0) {
                    continue;
                }
                
                max = Math.max(max, n);
                min = Math.min(min, n);
            }
            
            ans = ans + max - min;
        }
        
        return ans;
        
        
    }
    
   
}
