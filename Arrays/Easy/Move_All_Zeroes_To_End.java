import java.util.ArrayList;

public class Move_All_Zeroes_To_End {
    public static void main(String[] args) {
        int[] arr={0,4,0,1,0,4,0,7,8};
        brute_force(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        int[] arr1={0,4,2,0,1,1,0,6};
        optimal_approach(arr1);
        for(int i=0;i<arr1.length;i++){
            System.out.print(arr1[i]+" ");
        }

    }

    public static void brute_force(int[] arr){
        int n=arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                count++;
            }
            else{
                ans.add(arr[i]);
            }
        }
        for(int i=0;i<count;i++){
            ans.add(0);
        }
        int k=0;
        for(int i=0;i<ans.size();i++){
            arr[k++]=ans.get(i);
        }
        //TC=O(n)+O(count);
        //SC=O(n);
    }

    public static void optimal_approach(int[] arr){
        int n=arr.length;
        int i=0;
        for(int j=0;j<n;j++){
            if(arr[i]!=0){
                i++;
            }
            else{
                if(arr[j]!=0){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                    i++;
                }
            }
        }
        //TC=O(n);
        //SC=O(1);
    }
}
