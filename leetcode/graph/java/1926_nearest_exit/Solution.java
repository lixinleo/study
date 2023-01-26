import java.util.*;
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int m = maze.length;
        int n = maze[0].length;
        
        //will use bfs and use map to remember visited
         Queue<int[]> q = new LinkedList<>();
        
        //put entry into it
        q.add(entrance);
        
        HashMap<String, Integer> map = new HashMap<>();
        
        map.put(getStr(entrance), 1);
        
       
        
        int step =0;
        while (!q.isEmpty()) {
            int size = q.size();
            
            boolean moved = false;
            for (int i=0; i<size; i++) {
               // System.out.println("cje");
                int[] pos = q.poll();
                
                 int row = pos[0];
                 int col = pos[1];
                
                //check if pos is done
                if (isDone(maze, pos, entrance) && step !=0) {
                    return step;
                }
                
                //try to move up
                if (row != 0 && maze[row-1][col] != '+') {
                    int[] temp = new int[2];
                    temp[0] = row-1;
                    temp[1] = col;
                    String str = getStr(temp);
                    
                    if (!map.containsKey(str)) {
                   
                        q.add(temp);
                        moved = true;
                        map.put(str,1);
                    }
                }
                
                //try to move down
                if (row !=m-1 && maze[row+1][col] != '+') {
                    int[] temp = new int[2];
                    temp[0] = row+1;
                    temp[1] = col;
                   String str = getStr(temp);
                    
                    if (!map.containsKey(str)) {
                        q.add(temp);
                        moved = true;
                        map.put(str, 1);
                    }
                }
                
                //try to move left
                if (col != 0 && maze[row][col-1] !='+') {
                    int[] temp = new int[2];
                    temp[0] = row;
                    temp[1] = col-1;
                    String str = getStr(temp);
                    
                    if (!map.containsKey(str)) {
                        q.add(temp);
                        moved = true;
                        map.put(str,1);
                    }
                }
                
                //try to move right
                if (col !=n-1 && maze[row][col+1] != '+') {
                    int[] temp = new int[2];
                    temp[0] = row;
                    temp[1] = col+1;
                    String str = getStr(temp);
                    
                    if (!map.containsKey(str)) {
                        q.add(temp);
                        moved = true;
                        map.put(str,1);
                    }
                }
                
                
            }
            
            if (moved) {
                step=step+1;
            } else {
                return -1;
            }
        }
        
        return step;
      
    }
    
    
    public String getStr(int[] pos) {
        return pos[0] + "_" + pos[1];
    }
    
    public boolean isDone(char[][] maze, int[] pos, int[] entrance) {
        if (pos[0] == entrance[0] && pos[1] == entrance[1]) {
            return false;
        }
        int row = pos[0];
        int col = pos[1];
        
        if (row ==0 || col == 0) {
            return true;
        }
        
        if (row == maze.length -1) {
            return true;
        }
        
        if (col == maze[0].length-1) {
            return true;
        }
        
        return false;
    }
}
