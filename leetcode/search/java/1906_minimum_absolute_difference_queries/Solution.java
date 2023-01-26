import java.util.*;
class Solution {
    public static void main(String[] args) {
        int[] nums = {1,3,4,8};
        int[][] queries = new int[][] {
            {0,1},
            {1,2},
            {2,3},
            {0,3}
        };

        Solution s = new Solution();

        int[] result = s.minDifference(nums, queries);

        for(int i: result) {
            System.out.println(i);
        }
    }
    public int[] minDifference(int[] nums, int[][] queries) {
        //only have 1 10 100. Put number and index into a map
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for (int i=0; i<nums.length; i++) {
            int n = nums[i];
            
            if (map.containsKey(n)) {
                ArrayList<Integer> l = map.get(n);
                l.add(i);
                map.put(n, l);
            } else {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(n,l);
            }
            
        }
   
        
        int[] ans = new int[queries.length];
        int count = 0;
        
        
        //loop through queries
        for(int[] q : queries) {
            TreeSet<Integer> ns = new TreeSet<>();
            
            for (int n: map.keySet()) {
                ArrayList<Integer> l = map.get(n);
           
                
                if (isIn(l, q[0], q[1])) {
                  
                    ns.add(n);
                }
            }
           
      
            int min = Integer.MAX_VALUE;
            int pre = Integer.MAX_VALUE;
            
            if (ns.size()==1) {
                ans[count] = -1;
            } else {
                for(int k: ns) {
                    if (pre== Integer.MAX_VALUE) {
                        pre=k;
                        continue;
                    }
                    
                    min = Math.min(min, k-pre);
                    pre = k;
                }
                
                ans[count] = min;
            }
            
           
            count++;
        }
        
        return ans;
        
        
    }
    
    /**
     * See if this query is in the list
     *
     * @parameter l a list of index
     * @parameter start start index in query
     * @parameter end end index in query
     */
    public boolean isIn(ArrayList<Integer> l, int start, int end)
    {
        //find index in the ArrayList which is near our start
        int index = search(l, start);
     
        if (index==-1) {
            return false;
        }
        
        for (int i=index; i<l.size(); i++) {
            if (l.get(i)>=start && l.get(i)<=end) {
                return true;
            }
            
            if (l.get(i) > end) {
                return false;
            }
        }
        
        return false;
    }
    
    /**
     * Try to find the a index in array list. It is just smaller than start
     */
    public int search (ArrayList<Integer> l, int start)
    {
        //if start is bigger than max value in array list, no useful for us
        if (l.get(l.size()-1) < start) {
            return -1;
        }
       
        int high = l.size()-1;
        int low = 0;
        
        int mid = 0;
        while (low <= high) {
            mid = (int)((high+low)/2);
            
            int cur = l.get(mid);
            if (cur == start) {
                return mid;
            }
            
            if (cur > start) {
                high = mid-1;
            } else {
                low = mid +1;
            }
        }
        
        int ans= Math.min(low, high);
        
        //should not less than 0
        return Math.max(0, ans);
        
    }
    

}
