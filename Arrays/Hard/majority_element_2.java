import java.util.ArrayList;
import java.util.HashMap;

public class majority_element_2 {
    public static void main(String[] args) {
        int[] arr={6,3,6,6,3,6,4,6,6,6,2};
        System.out.println(bruteforce(arr));
        System.out.println(better_approach(arr));
        ArrayList<Integer> temp=new ArrayList<>();
        temp=optimzed_approach(arr);
        for(int i=0;i< temp.size();i++){
            System.out.print(temp.get(i)+" ");
        }
    }

    public static int bruteforce(int[] arr){
        int n=arr.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count>n/3){
                return arr[i];
            }
        }
        return -1;
        //TC=O(n^2);
        //SC=O(1);
    }

    public static int better_approach(int[] arr){
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(int i=0;i<n;i++){
            if(map.get(arr[i])>n/3){
                return arr[i];
            }
        }
        return -1;
        //TC=O(nlogn);
        //SC=O(n);
    }

    public static ArrayList<Integer> optimzed_approach(int[] arr){
        int n=arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
        int count1=0;
        int count2=0;
        int majel1=0;
        int majel2=0;
        for(int i=0;i<n;i++){
            if(count1==0&&arr[i]!=majel2){
                majel1=arr[i];
                count1=1;
            }
            else if(count2==0&&arr[i]!=majel1){
                count2=1;
                majel2=arr[i];
            }
            else if(arr[i]==majel1){
                count1++;
            }
            else if(arr[i]==majel2){
                majel2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int i=0;i<n;i++){
            if(arr[i]==majel1){
                count1++;
            }
            if(arr[i]==majel2){
                count2++;
            }
        }
        if(count1>n/3){
            ans.add(majel1);
        }
        if(count2>n/3){
            ans.add(majel2);
        }
        return ans;
    }
}
