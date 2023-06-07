import java.util.ArrayList;
public class Left_Rotation_By_K_Places {
    public static void main(String[] args) {
        int[] arr={1,4,6,3};
        Brute_force_approach(arr,3);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        int[] arr1={1,4,6,3};
        optimal_approach(arr1,3);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void Brute_force_approach(int[] arr,int k){
        int n= arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
        ArrayList<Integer> temp1=new ArrayList<>();
        ArrayList<Integer> temp2=new ArrayList<>();
        for(int i=0;i<k;i++){
            temp1.add(arr[i]);
        }
        for(int i=k;i<n;i++){
            temp2.add(arr[i]);
        }
        for(int i=0;i<temp2.size();i++){
            ans.add(temp2.get(i));
        }
        for(int i=0;i<temp1.size();i++){
            ans.add(temp1.get(i));
        }
        int l=0;
        for(int i=0;i<ans.size();i++){
            arr[l++]=ans.get(i);
        }
        //TC=O(n);
        //SC=O(n);
    }

    public static void optimal_approach(int[] arr,int k){
        int n=arr.length;
        k=k%n;
        if(k==0){
            return;
        }

        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        reverse(arr,0,n-1);
        //TC=O(n);
        //SC=O(1);
    }

    public static void reverse(int[] arr,int s,int e){
        while(s<e){
            int temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
        }
    }
}
