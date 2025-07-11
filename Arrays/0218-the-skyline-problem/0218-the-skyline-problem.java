class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        for (int[] curr : buildings) {        
            heights.add(new int[] {curr[0], -curr[2]});
            heights.add(new int[] {curr[1], curr[2]});
        }
        Collections.sort(heights, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]); 
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(0);
        int prev_maxi = 0;
        for (int[] height : heights) {  
            if (height[1] < 0) pq.offer(-height[1]);    
            else pq.remove(height[1]);                 
            int current_maxi = pq.peek();
            if (current_maxi != prev_maxi) {
                res.add(Arrays.asList(height[0], current_maxi));
                prev_maxi = current_maxi;
            }
        }
        return res;
    }
}

