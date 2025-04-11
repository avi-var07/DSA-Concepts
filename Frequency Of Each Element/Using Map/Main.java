import java.util.*;
class Main{
    static void Frequency(int arr[], int n){
        Map<Integer,Integer> map = new HashMap<>();
        //Java k maps c++ ki trh map[arr[i]]++ krne se kaam nhi krenge, tumhe containsKey se check krna padega, C++ std::map and std::unordered_map overload the [] operator, which makes it act like an array, and even creates a default value if the key is missing.
        //But in Java, Map is an interface, not a class with overloaded operators. Java doesn’t support operator overloading (e.g., you can’t define what [] or + means for custom types).
        //So, you have to use methods like put() and get() to interact with the map.


        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i])+1); //map.put(arr[i], map.get(arr[i])+1) is equivalent to map[arr[i]]++ in C++.
            //map.put(arr[i], map.get(arr[i])+1) matlab arr[i] index pe map.get(arr[i]) se jo value aaye usmei 1 jod kr put krdo!!
            else map.put(arr[i],1);
        }

        for(var i: map.entrySet()) System.out.println(i.getKey() + "->" + i.getValue());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println("Original Array: ");
        for(int i: arr) System.out.print(i + " ");
        System.out.println();

        System.out.println("Frequency of elements in the array: ");
        Frequency(arr,n);
        sc.close();

    }
}