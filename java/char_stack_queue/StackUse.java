class StackUse {
    //leetcode 1717
    public int maximumGain(String s, int x, int y) {
        //decide which one to replace first
    
        int scoreUnit;
        char first, last;
        
        if (x>=y) {
            first='a';
            last = 'b';
            scoreUnit =x;
        } else {
            first='b';
            last='a';
            scoreUnit=y;
        }
        
       
        int total = 0;
        
        //stack to push char into it
        Stack<Character> stack = new Stack<>();
        
        char c;
        for(int i=0; i<s.length(); i++) {
            c=s.charAt(i);
        
            
            
            if (stack.size() >0) {
                char top = stack.peek();
                
               
              
                if (first==top && last==c) {
                    total = total + scoreUnit;
                    stack.pop();
                } else {
                    stack.push(c);
                }
                
            } else {
                stack.push(c);
            }
        }
    
        //put it into another stack to reverse
        Stack<Character> stack1 = new Stack<>();
       
        while (!stack.empty()) {
           
            stack1.add(stack.pop());
        }
        
        //get new toF and scoreUnit
        if (first=='a') {
            first = 'b';
            last = 'a';
            scoreUnit = y;
        } else {
            first='a';
            last='b';
            scoreUnit =x;
        }
        
      
        while(!stack1.empty()) {
            c=stack1.pop();
            
            if (stack.size() >0) {
                char top = stack.peek();
                
                if (top==first && c==last) {
                    
                    total = total + scoreUnit;
                    stack.pop();
                } else {
                    stack.push(c);
                }
                
            } else {
                stack.push(c);
            }
        }
     
        return total;
    }
}
