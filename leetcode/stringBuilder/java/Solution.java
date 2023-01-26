import java.util.*;
class Solution
{
    public String afterRemove(String s, int n, int[] removable) {
        int[] need = new int[n];
        for (int i=0; i<n; i++) {
            need[i] = removable[i];
        }

        //before use string build to delete, need to sort index. Also delete from the end of string
        Arrays.sort(need);

        StringBuilder newStr = new StringBuilder(s);
        for(int j = need.length-1; j>=0; j--) {
            newStr.delete(need[j], need[j]+1);
        }


        return newStr.toString();

    }


}
