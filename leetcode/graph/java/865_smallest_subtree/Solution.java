import java.util.HashMap;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        //map used to store child->parent relation. Noted that values of nodes are unique.
        HashMap<Integer, TreeNode> map = new HashMap<>();
        
        //Use DFS to find the last level of nodes.
       Queue<TreeNode> q2 = new LinkedList<>();
        
        //q will store last level of nodes
        Queue<TreeNode> q = new LinkedList<>();
        
        q2.add(root);
        
        while(!q2.isEmpty()) {
            //copy into last level q
            q.clear();
            
            for (TreeNode node: q2) {
                q.add(node);
            }
            
            //dfs
            int size2 = q2.size();
          
            for (int i=0; i<size2; i++) {
                TreeNode temp2 = q2.poll();
                
                if (temp2.left != null) {
                    map.put(temp2.left.val, temp2);
                    q2.add(temp2.left);
                }
                
                if (temp2.right != null) {
                    map.put(temp2.right.val, temp2);
                   q2.add(temp2.right);
                }
            }
           
        }
        
        //if last level only has one element, we are done
        if (q.size()==1) {
            return q.poll();
        }
        
        //need to find shared parent of all elements in the last level
        return getSharedParent(q, map);
        
    }
    
    public TreeNode getSharedParent(Queue<TreeNode> q, HashMap<Integer, TreeNode> map) {
        //put parent here. If only one parent, we are done
        HashMap<Integer, TreeNode> parent = new HashMap<>();
       
        
        while (true) {
            int size = q.size();
            
            for (int i=0; i<size; i++) {
                TreeNode c = q.poll();
                
                //find parent. If does not have parent, it is root. return it.
                if (!map.containsKey(c.val)) {
                    return c;
                }
                
                TreeNode p = map.get(c.val);
           
                
                //put into parent hashmap
                parent.put(p.val, p);
            }
            
         
            //only one parent, so we find shared parent
            if (parent.size()==1) {
                for (int k: parent.keySet()) {
                    return parent.get(k);
                }
            }
            
            //if not, put back into q. Noted q is empty now.
            for (Integer j: parent.keySet()) {
                q.add(parent.get(j));
            }
            
            //clear parent hash
            parent.clear();
        }
    
    }
    
  
}
