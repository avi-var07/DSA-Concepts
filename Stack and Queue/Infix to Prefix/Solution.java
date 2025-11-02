import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Infix String: ");

        String s = sc.nextLine();
        s= reverse(s.toCharArray());

        String res = infixToPrefix(s, "");
        res = reverse(res.toCharArray());
        System.out.println("Prefix is: "+res);
        sc.close();
    }
    static String infixToPrefix(String s, String ans){
        Stack<Character>st = new Stack<>();
        
        for(char ch: s.toCharArray()){
            if((ch>='A'&&ch<='Z')||(ch>='a'&&ch<='z')||(ch>='0'&&ch<='9'))ans+=ch;
            else if(ch=='(')st.push(ch);
            else if(ch==')'){
                while(!st.isEmpty()&&st.peek()!='(')ans+=st.pop();

                st.pop();
            }
            else{
                if(ch=='^'){
                    while(!st.isEmpty()&&(priority(ch)<=priority(st.peek())))ans+=st.pop();
                }
                else{
                    while(!st.isEmpty()&&(priority(ch)<priority(st.peek())))ans+=st.pop();
                }

                st.push(ch);
            }
        }

        while(!st.isEmpty())ans+=st.pop();

        return ans;
    }
    static int priority(char ch){
        if(ch=='^')return 3;
        if(ch=='*'||ch=='/')return 2;
        if(ch=='+'||ch=='-')return 1;

        return -1;

    }
    static String reverse(char str[]){
        int start=0, end= str.length-1;
        while(start<=end){
            char temp = str[start];
            if(temp=='(')temp=')';
            else if(temp==')')temp='(';
            str[start]=str[end];
            str[end]=temp;
            start++;
            end--;
        }
        return new String(str);
    }
}