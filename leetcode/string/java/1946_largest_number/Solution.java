class Solution {
  public String maximumNumber(String num, int[] change) {
       
   
        //find i where we start to mutate
        int start = -1;
        int ct = 0;
        for (int i=0; i<num.length(); i++) {
            ct = num.charAt(i) - '0';
            
            if (change[ct] >ct) {
                start = i;
                break;
            }
        }
        
        //do not find and we are done
        if (start==-1) {
            return num;
        }
        
        //let us change from star and find the end
        int end = -1;
        
        for (int i=start; i<num.length(); i++) {
           
            ct = num.charAt(i) - '0';
            
            if (change[ct] <ct) {
                end = i-1;
                break;
            }
            
        }
        
        //if we do not find, it goes to the end
        if (end == -1) {
            end = num.length()-1;
        }
        
    
     
       //Using String Builder to ensure linear time complexity as java strings are immutable
       //for this question. running time from 865 to 14ms!!
       StringBuilder result = new StringBuilder("");
       
       for (int i=start; i<=end; i++) {
          
           ct = num.charAt(i) - '0';
           result.append(change[ct]);
       }
       
       return num.substring(0, start) + result.toString() + num.substring(end+1, num.length());
        
     
   }
}
