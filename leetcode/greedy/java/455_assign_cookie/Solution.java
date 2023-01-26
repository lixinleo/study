import java.util.*;
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //to be greedy, do not wast size of cookie. To assign as smallest cookie as possible
        //therefore we sort both array
        Arrays.sort(g);
        Arrays.sort(s);
        
        int ans = 0;
        
        //remember min greedy of child. start from 0. point is the index of array g
        int minG = g[0];
        int point = 0;
        
        //loop through cookie array
        for (int c: s) {
            //find the cookie which meet greedy
            if (c>=minG) {
                ans++;
                point++;
                
                //make sure we are not out range of children array
                if (point>=g.length) {
                    break;
                } else {
                    //update min greedy
                    minG = g[point];
                }
            }
        }
        
        
        return ans;
  
    }
}
