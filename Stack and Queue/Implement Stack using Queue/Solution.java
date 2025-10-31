import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyStack st  =new MyStack();
        System.out.println("Enter number of operations: ");
        int op = sc.nextInt();
        sc.nextLine();
        System.out.println("Available operations: push, pop, top, empty");
        for (int i = 0; i < op; i++) {
            System.out.print("Enter operation: ");
            String s = sc.nextLine().toLowerCase();

            switch (s) {
                case "push":
                    System.out.print("Enter value to push: ");
                    int val = sc.nextInt();
                    sc.nextLine();
                    st.push(val);
                    System.out.println(val + " pushed.");
                    break;

                case "pop":
                    if (st.empty()) System.out.println("Stack is empty!");
                    else System.out.println("Popped: " + st.pop());
                    break;

                case "top":
                    if (st.empty()) System.out.println("Stack is empty!");
                    else System.out.println("Top element: " + st.top());
                    break;

                case "empty":
                    System.out.println("Stack empty? " + st.empty());
                    break;

                default:
                    System.out.println("Invalid operation!");
                    break;
            }
        }

        sc.close();
    }
}
class MyStack {
    Queue<Integer>q = new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        int s = q.size();
        q.offer(x);
        for(int i=0;i<s;i++)q.offer(q.poll());
            
        
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        if(q.size()==0)return true;

        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */