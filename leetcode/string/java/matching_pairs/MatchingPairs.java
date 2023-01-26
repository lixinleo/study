import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here


class MatchingPairs {

  // Add any helper functions you may need here
  

  int matchingPairs(String s, String t) {
    // Write your code here
    //see if s and t are the same
    HashMap<Integer, char[]> map = new HashMap<>();
    
    HashMap<Character, Integer> smap = new HashMap<>();
    
    for (int i=0; i <s.length(); i++) {
      char sc = s.charAt(i);
      char tc = s.charAt(i);
      
      if (smap.containsKey(sc)) {
        smap.put(sc, smap.get(sc) +1);
      } else {
        smap.put(sc, 1);
      }
      
      if (sc != tc) {
        char[] temp = new char[2];
        temp[0] = sc;
        temp[1] = tc;
        map.put(i, temp);
      }
    }
    
    
    
    System.out.println(smap);
    //specail case. s = t
    if (s.equals(t)) {
        for (char c: smap.keySet()) {
          if (smap.get(c) >=2) {
            return s.length();
          }
        }
     
      
        return s.length()-2;
      }
    
    //only on difference
    if (map.size() ==1) {
      return s.length()-2;
      
    }
    
    //if more than one diffrence
    //build index array
    ArrayList<Integer> sindex = new ArrayList<>();
    
    for (int i: map.keySet()) {
      sindex.add(i);
    }
    
    //do exchange
    int incr = 0;
    int max = 0;
    for (int i=0; i<sindex.size(); i++) {
      if (max==2) {
        break;
      }
      incr = 0;
      int leo = sindex.get(i);
      System.out.print("leo:" + leo + " ");
      System.out.println(map.get(leo));
      char first = map.get(sindex.get(i))[0];
      
      for (int j=i+1; j<sindex.size(); j++) {
        if (i==j) {
          continue;
        }
        char second = map.get(sindex.get(j))[0];
        
        //swap and compare with t
        if (first == map.get(sindex.get(j))[1]) {
          incr++;
        }
        
        if (second == map.get(sindex.get(i))[1]) {
          incr++;
        }
        
        if (max < incr) {
          max=incr;
        }
        
        if (max ==2) {
          break;
        }
        
        incr=0;
        
      }
    }
    
    return s.length() - map.size() + incr;
    
    //not equals
    
  }











  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;
  void check(int expected, int output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printInteger(expected); 
      System.out.print(" Your output: ");
      printInteger(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printInteger(int n) {
    System.out.print("[" + n + "]");
  }
  public void run() {
    String s_1 = "abcde";
    String t_1 = "adcbe";
    int expected_1 = 5;
    int output_1 = matchingPairs(s_1, t_1);
    check(expected_1, output_1);

    String s_2 = "abcd";
    String t_2 = "abcd";
    int expected_2 = 2;
    int output_2 = matchingPairs(s_2, t_2);
    check(expected_2, output_2);

    // Add your own test cases here
    
  }
  public static void main(String[] args) {
    new MatchingPairs().run();
  }
}
