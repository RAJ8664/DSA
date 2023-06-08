import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Union_Of_Two_Sorted_Array {
    public static void main(String[] args) {
        int[] arr1={1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2={2, 3, 4, 4, 5, 11, 12};
        ArrayList<Integer> ans=new ArrayList<>();
        ans=optimal_appraoch(arr1,arr2);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
    public static ArrayList<Integer> brute_force_method(int[] arr1,int arr2[]){
        int n=arr1.length;
        int m=arr2.length;
        ArrayList<Integer> ans=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(arr1[i])){
                int key=map.get(arr1[i]);
                map.put(arr1[i],++key);
            }
            else{
                map.put(arr1[i],1);
            }
        }
        for(int i=0;i<m;i++){
            if(map.containsKey(arr2[i])){
                int key=map.get(arr2[i]);
                map.put(arr2[i],++key);
            }
            else{
                map.put(arr2[i],1);
            }
        }
        for(int num:map.keySet()){
            ans.add(num);
        }
        return ans;

        //TC=(n+m)(log(m+n));
        //SC=O(m+n) if space of union or our ans arraylist is considered;
    }

    public static ArrayList<Integer> brute_force_method_1(int[] arr1,int[] arr2){
        int n=arr1.length;
        int m=arr2.length;
        ArrayList<Integer> ans=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<m;i++){
            set.add(arr2[i]);
        }
        for(int num:set){
            ans.add(num);
        }
        return ans;
        //TC=(n+m)(log(m+n));
        //SC=O(m+n) if space of union or our ans arraylist is considered;
    }

    public static ArrayList<Integer> optimal_appraoch(int[] arr1,int[] arr2){
        int n=arr1.length;
        int m=arr2.length;
        ArrayList<Integer> ans=new ArrayList<>();
        int i=0;
        int j=0;
        while(i<n&&j<m){
            if(arr1[i]==arr2[j]){
                if(!ans.contains(arr1[i])){
                    ans.add(arr1[i]);
                }
                i++;
                j++;
            }
            else if(arr1[i]<arr2[j]){
                if(!ans.contains(arr1[i])){
                    ans.add(arr1[i]);
                }
                i++;
            }
            else{
                if(!ans.contains(arr2[j])){
                    ans.add(arr2[j]);
                }
                j++;
            }
        }
        while(i<n){
            if(!ans.contains(arr1[i])){
                ans.add(arr1[i]);

            }
            i++;
        }
        while(j<m){
            if(!ans.contains(arr2[j])){
                ans.add(arr2[j]);
            }
            j++;
        }
        return ans;
        //TC=O(m+n);
        //SC=O(m+n) if our space of our ans arraylist is considered;
    }


}
