import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();
        System.out.println("Enter "+n+" operations: ");
        int top = -1;
        int st [] = new int[n];
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.println("Enter operation: 'push', 'pop', 'top', 'size' ");
            String op = sc.nextLine().toLowerCase();
            switch (op) {
                case "push":
                    if(top==n-1){
                        System.out.println("Stack overflow");
                        break;
                    }
                        
                    
                    System.out.println("Enter value to push: ");
                    int ele = sc.nextInt();
                    sc.nextLine();
                    top = push(st, ele, top, n);
                    
                    break;
                case "pop":
                    if(top==-1){
                        System.out.println("Stack underflow");
                        break;
                    }

                    System.out.println("Element popped: "+st[top]);
                    top = pop(st, top);
                    break;
                
            
                case "top":
                    if(top==-1){
                        System.out.println("Stack is empty!");
                        break;
                    }
                    System.out.println("Element at top is: "+top(st, top));
                    break;
                
                case "size":
                    System.out.println("Size is: "+size(st, top));
                    break;
                default:
                    System.out.println("Enter either: 'push', 'pop', 'top', 'size' ");
                    break;
            }
        }        

        sc.close();
    }
    static int push(int arr[], int ele, int top, int n){
        top++;
        arr[top]=ele;

        return top;
    }
    static int pop(int arr[], int top){

        top--;

        return top;
    }   
    static int top(int arr[], int top){
        return arr[top];
    }
    static int size(int arr[], int top){
        return top+1;
    }
}