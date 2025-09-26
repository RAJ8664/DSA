class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] arr=new int[2];
        arr[0]=-1;
        arr[1]=-1;
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if (isprime(i)) ans.add(i);
        }
        int len=ans.size();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<len-1;i++){
            int x=Math.abs(ans.get(i)-ans.get(i+1));
            min=Math.min(min,x);
        }
        for(int i=0;i<len-1;i++){
            if(Math.abs(ans.get(i)-ans.get(i+1))==min){
                arr[0]=ans.get(i);
                arr[1]=ans.get(i+1);
                break;
            }
        }
        return arr;
    }
    public static boolean isprime(int n){
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}