import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class merge_overlapping_intervals {

    public static void main(String[] args) {
        /**
         * to change List<List<Integer>> to in[][]
         * use this
         * int[][] ints = ans.stream().map(x -> x.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
         * ints=>array name;
         * ans=>list<list<Integer>>> name;
         *
         */

        int[][] arr={{1, 4}, {4, 5}};
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ans=optimized_approach(arr);
        for(ArrayList<Integer> row:ans){
            for(int ele:row){
                System.out.print(ele+" ");
            }
            System.out.println();
        }





    }
    public static ArrayList<ArrayList<Integer>> bruteforce(int[][] arr){
        int n=arr.length;
        Arrays.sort(arr,new Comparator<int[]>() {
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });

        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            int start=arr[i][0];
            int end=arr[i][1];
            if(!ans.isEmpty()&&end<=ans.get(ans.size()-1).get(1)){
                continue;
            }
            for(int j=i+1;j<n;j++){
                if(end>=arr[j][0]){
                    end=Math.max(end,arr[j][1]);
                }
                else{
                    break;
                }
            }
            ans.add(new ArrayList(Arrays.asList(start,end)));
        }
        return ans;
        //TC=O(nlogn)+O(2n);
        //SC+O(n);
    }

    public static ArrayList<ArrayList<Integer>> optimized_approach(int[][] arr){
        int n=arr.length;
        Arrays.sort(arr, new Comparator<int[]>() {
           public int compare(int[] a,int[] b){
               return a[0]-b[0];
           }
        });
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            int start=arr[i][0];
            int end=arr[i][1];
            if(ans.isEmpty()){
                ans.add(new ArrayList<>(Arrays.asList(start,end)));
            }
            else if(start<=ans.get(ans.size()-1).get(1)){
                int max=Math.max(end,ans.get(ans.size()-1).get(1));
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add((ans.get(ans.size()-1).get(0)));
                temp.add(max);
                ans.set(ans.size()-1,temp);
            }
            else if(start>ans.get(ans.size()-1).get(1)){
                ans.add(new ArrayList<>(Arrays.asList(start,end)));
            }
        }
        return ans;
        //TC=O(nlogn)+(n);
        //SC=O(n);
    }
}
