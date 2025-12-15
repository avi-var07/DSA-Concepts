import java.util.*;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        List<List<Integer>>ans = uniqueSubsets(arr);
        for(List<Integer>ele: ans)System.out.print(ele+" ");
        
        sc.close();
    }
    static List<List<Integer>>uniqueSubsets(int arr[]){
        Arrays.sort(arr);
        List<Integer>ds = new ArrayList<>();
        List<List<Integer>>ans = new ArrayList<>();
        generate(0, arr, ds, ans);
        Collections.sort(ans,(a,b)->{
            int n = Math.min(a.size(), b.size());
            for (int i = 0; i < n; i++) {
                if (!a.get(i).equals(b.get(i)))return a.get(i) - b.get(i);
            }
            return a.size() - b.size();
        });
        return ans;
    }
    static void generate(int index, int arr[], List<Integer>ds, List<List<Integer>>ans){
        ans.add(new ArrayList<>(ds));
        for(int i = index;i<arr.length;i++){
            if(i>index&&arr[i]==arr[i-1])continue;
            ds.add(arr[i]);
            generate(i+1, arr, ds, ans);
            ds.remove(ds.size()-1);
        }
    }

}