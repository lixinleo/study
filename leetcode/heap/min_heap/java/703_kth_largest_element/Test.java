import java.util.*;
class Test {
    public static void main(String[] args)  {

        int[] arr = {2, 1, 2, 1, 2};
        PriorityQueue<Integer> p = new PriorityQueue<Integer>();

        int[] ans = new int[arr.length];

        for (int i=0; i<arr.length; i++) {
            if (p.size()<3) {
                p.add(arr[i]);
            }

            if (p.size() <=2) {
                ans[i] = -1;
                continue;
            }


            if (p.size()==3) {
                int val = arr[i];

                if (val > p.peek() && i>2) {
                    p.poll();
                    p.add(val);
                }
            }


            int product = 1;

             for (int j: p) {
               product = product*j;
               }


            ans[i] = product;



        }

        for (int n: ans) {
            System.out.println(n);
        }
    }
}
