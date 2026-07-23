import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        String arr[] = new String[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.next();

        Solution sol=new Solution();
        for(String ele: arr)sol.insert(ele);
        sc.close();
    }
    class Trie{
        Trie children[];
        boolean eow;
        
        Trie(){
            children=new Trie[26];
            for(int i=0;i<26;i++)children[i]=null;
            eow=false;
        }
    }
    Trie root= new Trie();

    void insert(String s){

        Trie curr=root;
        for(char ch: s.toCharArray()){
            int idx=ch-'a';
            if(curr.children[idx]==null)curr.children[idx]=new Trie();
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    boolean search(String key){
        Trie curr =root;

        for(char ch: key.toCharArray()){
            int idx=ch-'a';
            if(curr.children[idx]==null)return false;
            curr=curr.children[idx];
        }
        return curr.eow;
    }
    boolean startsWith(String key){
        Trie curr =root;

        for(char ch: key.toCharArray()){
            int idx=ch-'a';
            if(curr.children[idx]==null)return false;
            curr=curr.children[idx];
        }
        return true;
    }
}
