class QueueUse {
    //leetcode 3
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> q = new LinkedList();
        
        //use slide window.
        int maxL = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            //if c is not in the q, add it
            if (!q.contains(c)) {
                q.add(c);
            } else {
                //remember size first
                if (q.size()>maxL) {
                    maxL=q.size();
                }
                
                //add c. Then remove duplicated element
                q.add(c);
                
                //use set to check if we still have duplicated now.
                Set<Character> set = new HashSet<Character>();
                set.addAll(q);
                
                //always remove element from begining
                while (set.size() != q.size()) {
                    q.remove();
                    
                    //clear set and add q which has pop a element
                    set.clear();
                    set.addAll(q);
                }
    
            }
        }
        
        //if s does not have dupilcate, will not go to size and set maxL.
        //Therefore, need to compare q size
        return Math.max(maxL, q.size());
        
    }
}
