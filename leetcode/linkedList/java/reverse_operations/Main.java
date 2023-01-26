import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here


class Main {
  
  class Node {
    int data;
    Node next;
    Node(int x) {
      data = x;
      next = null;
    }
  }

  // Add any helper functions you may need here
  

  Node reverse(Node head) {
    // Write your code here
    ArrayList<Integer> l = new ArrayList<Integer>();
    
    //remember start and end of subpart
    int p1 = -1;
    int p2 = -1;
    ArrayList<int[]> b = new ArrayList<int[]>();
    
    Node cur = head;
    
    l.add(cur.data);
    
    if (cur.data %2==0) {
      p1 = 0;
    }
    
    //remember iteration
    int count = 1;
    while(cur.next != null) {
      cur = cur.next;
      l.add(cur.data);
      
      //check boundary
      if (cur.data %2 == 0) {
        if (p1 == -1) {
          p1 = count;
        }
      } else {
        //find odd element
        if (p1 != -1) {
          p2 = count -1;
          
          //remember and reset
          int[] temp = new int[2];
          temp[0] = p1;
          temp[1] = p2;
          
          p1 = -1;
          p2 = -1;
          b.add(temp);
          
        }
        
      }
      
      count++;
    }
    
    //if we still have p1 set
    if (p1 != -1 && p2==-1) {
      p2 = l.size()-1;
      int[] temp2 = new int[2];
      temp2[0] = p1;
      temp2[1] = p2;
      b.add(temp2);
    }

    //do reverse
    for(int[] t: b) {
      Stack<Integer> st = new Stack<Integer>();
      for (int i=t[0]; i<=t[1]; i++) {
        st.push(l.get(i));
        
      }
      
      for (int i=t[0]; i<=t[1]; i++) {
        l.set(i, st.pop());
      }
      
    }
    
    //build output
    Node ans = new Node(l.get(0));
    Node nt = ans;
    
    for (int i=1; i<l.size(); i++) {
      Node tn = new Node(l.get(i));
      nt.next = tn;
      nt = tn;
    }
    
    nt.next = null;
    
    
    
    return ans;
    
  }












  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;

  void printLinkedList(Node head) {
    System.out.print("[");
    while (head != null) {
      System.out.print(head.data);
      head = head.next;
      if (head != null)
        System.out.print(" ");
    }
    System.out.print("]");
  }
  void check(Node expectedHead, Node outputHead) {
    boolean result = true;
    Node tempExpectedHead = expectedHead;
    Node tempOutputHead = outputHead;
    while (expectedHead != null && outputHead != null) {
      result &= (expectedHead.data == outputHead.data);
      expectedHead = expectedHead.next;
      outputHead = outputHead.next;
    }
    if (!(expectedHead == null && outputHead == null)) result = false;

    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    } else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printLinkedList(tempExpectedHead); 
      System.out.print(" Your output: ");
      printLinkedList(tempOutputHead);
      System.out.println();
    }
    test_case_number++;
  }
  Node createLinkedList(int[] arr) {
    Node head = null;
    Node tempHead = head;
    for (int v : arr) {
      if (head == null) {
        head = new Node(v);
        tempHead = head;
      } else {
        head.next = new Node(v);
        head = head.next;
      }
    }
    return tempHead;
  }
  
  public void run() {
  
    int[] arr_1 = {1, 2, 8, 9, 12, 16};
    int[] expected1 = {1, 8, 2, 9, 16, 12};
    Node head_1 = createLinkedList(arr_1);
    Node expected_1 = createLinkedList(expected1);
    Node output_1 = reverse(head_1);
    check(expected_1, output_1);

    int[] arr_2 = {2, 18, 24, 3, 5, 7, 9, 6, 12};
    int[] expected2 = {24, 18, 2, 3, 5, 7, 9, 12, 6};
    Node head_2 = createLinkedList(arr_2);
    Node expected_2 = createLinkedList(expected2);
    Node output_2 = reverse(head_2);
    check(expected_2, output_2);

  
    // Add your own test cases here
    
  }
  
  public static void main(String[] args) {
    new Main().run();
  }
}
