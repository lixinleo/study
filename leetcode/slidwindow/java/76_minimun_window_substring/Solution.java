import java.util.*;
class Solution {
    public String minWindow(String s, String t) {
        
        //put string t into map
        HashMap<Character, Integer> tm = new HashMap<Character, Integer>();
        
        for (char c: t.toCharArray()) {
            if (tm.containsKey(c)) {
                tm.put(c, tm.get(c)+1);
            } else {
                tm.put(c,1);
            }
        }
        
        //map used to store current string
        HashMap<Character, Integer> smap = new HashMap<Character, Integer>();
        
        //used for slid window
        int left = 0;
        int right = 0;
        
        //store ans
        String ans="";
        
        //store current string
        String part="";
        
      
        //loop through s to find min substring
        while (true) {
            //either point reach the end, we are done
            if (right>=s.length() || left>=s.length()) {
                break;
            }
            
            char c= s.charAt(right);
            
            //if c is not in t, just move the right point
            if (!tm.containsKey(c)) {
                right = right +1;
                continue;
            }
            
            //put into smap
            if (smap.containsKey(c)) {
                smap.put(c, smap.get(c) +1);
            } else {
                smap.put(c, 1);
            }
            
            //do not match; move rigth again.
            if (!Solution.sHasT(smap, tm)) {
                right = right +1;
                continue;
            }
            
            //this part contain t
            part = s.substring(left, right+1);
            
            if (ans.length()==0) {
                ans = part;
            } else {
                if (ans.length() > part.length()) {
                    ans = part;
                }
            }
            
            //now we have right. Now slid window to move left to righ, and keep right still
            while (left <= right) {
                //remove char at left from map
                 c = s.charAt(left);
                
                if (smap.containsKey(c)) {
                    smap.put(c, smap.get(c)-1);
                }
                
                //after remove, move left point
                left = left +1;
                
                //not match anymore. stop left here
                if (!Solution.sHasT(smap, tm)) {
                    break;
                }
                
                //after move left point, we still find one matched
                part = s.substring(left, right+1);
                
                if (ans.length() > part.length()) {
                    ans = part;
                }
           
            }
            
            right = right +1;
            
        }
        
        return ans;
        
    }
    
     public static boolean sHasT(HashMap<Character, Integer> smap, HashMap<Character, Integer> tmap) {
         
         if (smap.size() < tmap.size()) {
             return false;
         }
         
         for (Character c: tmap.keySet()) {
             if (!smap.containsKey(c)) {
                 
                 return false;
             }
             
             if (smap.get(c) < tmap.get(c)) {
                
                 return false;
             }
         }
         
        return true;
        
    }
    
}
