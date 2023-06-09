import java.util.Arrays;
import java.util.HashMap;

public class Two_Sum {
    public static void main(String[] args) {
        int[] arr={2,6,5,8,11};
        int[] ans=new int[2];
        ans=brute_force(arr,14);
        for(int i=0;i<2;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();

        ans=optimal_approach_1(arr,14);
        for(int i=0;i<2;i++){
            System.out.print(ans[i]+" ");
        }
    }

    public static int[] brute_force(int[] arr,int target){
        int[] ans=new int[2];  //assuming there is only one pair or the question is asked
                                // to return the index of any one pair;
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                    break;
                }
            }
        }
        return ans;
        //TC=O(n^2);
        //SC=O(1);
    }

    public static int[] optimal_approach(int[] arr,int target){
        int n=arr.length;
        int[] ans=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int is_present=target-arr[i];
            if(map.containsKey(is_present)){
                ans[0]=map.get(is_present);
                ans[1]=i;
            }
            else{
                map.put(arr[i],i);
            }
        }
        return ans;
        //TC=O(nlogn);
        //SC=O(n)
    }

    public static int[] optimal_approach_1(int[] arr,int target){
        int n=arr.length;
        int[] ans=new int[2];
        int[] temp=new int[n];
        for(int i=0;i<n;i++){
            temp[i]=arr[i];
        }
        Arrays.sort(temp);
        int i=0;
        int j=n-1;
        int x=0;
        int y=0;
        while(i<=j){
            if(temp[i]+temp[j]==target){
                x=temp[i];
                y=temp[j];
                break;
            }
            else if(temp[i]+temp[j]>target){
                j--;
            }
            else{
                i++;
            }
        }
        for(int l=0;l<n;l++){
            if(arr[l]==x){
                ans[0]=l;
            }
            if(arr[l]==y){
                ans[1]=l;
            }
        }
        return ans;
        //TC=O(nlogn);
        //SC=O(n);


    }
}
