import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println("Enter number of queries: ");
        int m =sc.nextInt();

        int queries[][] =new int[m][3];

        for(int i=0;i<m;i++){
            System.out.println("Enter type (1 for update, 2 for find query): ");
            int type=sc.nextInt();

            if(type==1){
                System.out.println("Enter index: ");
                int index=sc.nextInt();
                System.out.println("Enter new value: ");
                int val = sc.nextInt();
                queries[i][0]=type;
                queries[i][1]=index;
                queries[i][2]=val;
            }
            else if(type==2){
                System.out.println("Enter start: ");
                int start =sc.nextInt();
                System.out.println("Enter end: ");
                int end =sc.nextInt();
                queries[i][0]=type;
                queries[i][1]=start;
                queries[i][2]=end;
            }
            else System.exit(0);
        }

        SegmentTree st= new SegmentTree(arr);

        List<Integer>ans = new ArrayList<>();
        for(int ele[]: queries){
            if(ele[0]==2)ans.add(st.query(ele[1], ele[2]));
            else if(ele[0]==1)st.update(ele[1], ele[2]);
        }

        for(int ele: ans)System.out.print(ele+" ");
        sc.close();
    }

    static class SegmentTree{
        int st[];
        int n;
        SegmentTree(int arr[]){
            this.n=arr.length;
            st=new int[4*n];
            buildTree(0, n-1, 0, arr);
        }
        void buildTree(int left, int right, int ind, int arr[]){
            if(left==right){
                st[ind]=arr[left];
                return;
            }
    
            int mid=left+(right-left)/2;
            buildTree(left,mid, 2*ind+1, arr);
            buildTree(mid+1,right, 2*ind+2, arr);
            
            st[ind]=st[2*ind+1]+st[2*ind+2];
        }
        void update(int left, int right, int ind, int i, int val){
            if(left==right){
                st[ind]=val;
                return;
            }
            int mid =left+(right-left)/2;
            if(i<=mid)update(left, mid, 2*ind+1, i, val);
            else update(mid+1, right, 2*ind+2, i, val);

            st[ind]=st[2*ind+1]+st[2*ind+2];
        }
        void update(int ind, int val){update(0, n-1, 0, ind, val);}
        int query(int left, int right, int ind, int start, int end){
            if(left>end||right<start)return 0;

            if(left>=start&&right<=end)return st[ind];
            
            int mid =left+(right-left)/2;
            int leftSum =query(left, mid, 2*ind+1, start, end);
            int rightSum =query(mid+1, right, 2*ind+2, start, end);

            return leftSum+rightSum;
        }
        int query(int start, int end){return query(0, n-1, 0, start, end);}
    }
}