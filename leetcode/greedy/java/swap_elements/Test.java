import java.util.*;
public class Test {

    public static void main(String[] args) {
        int[] arr = {8,9,11,2,1};
        int k = 2;

        int[] ans = Test.swapElements(arr, k);

        for (int n: ans) {
            System.out.println(n);
        }
    }

    //given an element n, try to find a index match this element and we can move it
    public static int findIndex(int[] arr, int n, int posTo, int leftMove) {
        int ans = 0;

        if (arr[posTo]<=n) {
            return 0;
        }

        for (int i=posTo+1; (i<posTo+leftMove+2) && i<arr.length; i++) {
            if (arr[i] == n && (i-posTo)<= leftMove) {
                return i;
            }
        }

        return ans;

    }

    public static int[] swapElements(int[] arr, int k) {
        //special case
        if (arr.length ==1) {
            return arr;
        }

        //swap count left
        int left = k;

        //position to move now. First to move possible smallest one to the first position. Then move to 1, 2 etc
        int pos=0;

        //put arr into priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int n: arr) {
            pq.add(n);
        }

        while (true) {
            //if queue is empty, we are done
            if (pq.isEmpty()) {
                break;
            }

            //can not swap, done
            if (left<=0) {
                break;
            }

            //if desired postion is last position, done
            if (pos == arr.length-1) {
                break;
            }

            //step one. pop the smallest element from queue. Try to move it. need to check if possible
            int tryMoveN = pq.poll();

            int moveIndex = Test.findIndex(arr, tryMoveN, pos, left);

            //if we can not move this number, clear it from queue
            if (moveIndex == 0) {
                while(!pq.isEmpty() && pq.peek() == tryMoveN) {
                    pq.poll();
                }

                //try another number
                continue;
            }

            //ok, we can move
            arr = Test.swap(arr, moveIndex, pos);

            //update parameter
            left = left - (moveIndex-pos);
            pos = pos +1;
        }

        return arr;


    }

    public static int[] swap(int[] input, int after, int before) {

        int[] output = new int[input.length];
        int temp = input[after];

        for (int i=0; i<input.length; i++) {
            if (i<before || i>after) {
                output[i] = input[i];
            } else {
                if (i>before) {
                    output[i] = input[i-1];
                }
            }
        }

        output[before] = temp;

        return output;

    }

}
