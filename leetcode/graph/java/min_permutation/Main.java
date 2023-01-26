import java.io.*;
import java.util.*;


class Main {

    class Pair {
        int val;
        String key;
        public Pair(String key, int val) {
            this.val = val;
            this.key = key;
        }

        public int getVal() {
            return this.val;
        }

        public String getKey() {
            return this.key;
        }

    }


    public static void main(String[] args) {
        int[] arr = {3,1,2};

        Main s = new Main();

        int ans = s.minOperations(arr);
        System.out.println("ans:" +ans);
    }

    /**
     * Solve it by BFS.  The next nodes from current node are by applied reverse part of current string.
     * Find how many steps needed to reach sorted array. BFS tell us that it is guranteened to be min operations.
     */
    int minOperations(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i: arr) {
            sb.append(i);
        }

        String start = sb.toString();

        //System.out.println("start:" + start);

        //destination
        Arrays.sort(arr);
        sb = new StringBuilder();
        for(int i: arr) {
            sb.append(i);
        }

        String dest = sb.toString();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));

        HashSet<String> set = new HashSet<>();
        set.add(start);

        if (start.equals(dest)) {
            return 0;
        }

        while(!q.isEmpty()) {
            Pair node = q.poll();

            String startnode = node.getKey();

            if (startnode.equals(dest)) {
                return node.getVal();
            }

            //we are doing BFS. That means one step a time. From current string,
            //by reverse subpart once, find all new strings and put them in the queue.
            //also update count by one
            for (int i=1; i<arr.length; i++) {
                for (int j=0; j<i; j++) {
                    String reverse = startnode.substring(j, i+1);

                    StringBuffer sbr = new StringBuffer(reverse);
                    sbr.reverse();
                    reverse = sbr.toString();

                    //build new node
                    String newnode = "";

                    if (j>0)
                        newnode = startnode.substring(0,j);
                    if (i+1<arr.length)
                        newnode+=reverse + startnode.substring(i+1);
                    else
                        newnode+=reverse;

                    if (!set.contains(newnode)) {
                        set.add(newnode);
                        //System.out.println("new node:" + newnode + " val:" + (node.getVal()+1));
                        q.add(new Pair(newnode, node.getVal()+1));
                    }

                }
            }


        }

        return -1;


    }
}
