class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[n];
        for(int i = 0;i < n; i++) ans[i] = arr[i];
        Arrays.sort(ans);
        int y = 1;
        for(int i = 0;i < n; i++){
            if(!map.containsKey(ans[i])){
                map.put(ans[i], y);
                y++;
            }
        }
        int[] answer = new int[n];
        int k = 0;
        for(int i = 0;i < n; i++){
            int x = map.get(arr[i]);
            answer[k] = x;
            k++;
        }
        return answer;
    }
}