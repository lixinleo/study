class Solution {
    public String customSortString(String order, String str) {
        //store char into array because of only 26 low cases
        int[] letters = new int[26];
        for (int i=0; i<str.length(); i++) {
            int index = str.charAt(i) - 97;
            letters[index] = letters[index] +1;
        }
        
        //build ans;
        String ans = "";
        
        for (int i=0; i<order.length(); i++) {
            int index = order.charAt(i) - 97;
            
            if (letters[index] > 0) {
                String cs = String.valueOf(order.charAt(i));
                ans = ans + cs.repeat(letters[index]);
                letters[index] = 0;
            }
        }
        
        //build left
        for (int i=0; i<26; i++) {
            if (letters[i] >0) {
                char c = (char)(i+97);
                String cs = String.valueOf(c);
                ans = ans + cs.repeat(letters[i]);
            }
        }
        
        return ans;
    }
}
