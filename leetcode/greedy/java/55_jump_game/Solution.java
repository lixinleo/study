class Solution {
    public boolean canJump(int[] nums) {
        //use greedy algorithm
        
        //this is the index of goal position. It is start from the end
        int goal = nums.length-1;
        for (int i=nums.length-2; i>=0; i--) {
            
            //how many step we can jump from here
            int step = nums[i];
            
            //the distance between goal and current position
            int diff = goal - i;
            
            //if we can jump to goal, reposition goal to i
            if (step>= diff ) {
                goal = i;
            }
            
            
        }
        
        //if we can reposition goal to 0, we can jump from 0 to the end
        return goal == 0;
        
    }
}
