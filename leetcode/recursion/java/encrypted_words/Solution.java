public class Solution{
    public static void main(String[] args) {
        String s = findEncryptedWord("abcxcba");

        System.out.println(s);
    }

    public static String findEncryptedWord(String s) {
        if (s.length()<=2) {
            return s;
        }

        //find middle
        int m = 0;

        if (s.length() %2 ==0) {
            m = (int)(s.length()/2 -1);
        } else {
            m = (int)Math.floor(s.length()/2);
        }

        String left = s.substring(0,m);
        String right = s.substring(m+1, s.length());

        return "" + s.charAt(m) + findEncryptedWord(left) + findEncryptedWord(right);

    }
}
