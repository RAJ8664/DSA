class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>(); 
        Map<Integer, Integer> node = new HashMap<>();
        for(int[] p : pairs){
            if(!graph.containsKey(p[0])) graph.put(p[0], new ArrayList<>());
            graph.get(p[0]).add(p[1]);  
            node.put(p[0], node.getOrDefault(p[0], 0) - 1);  
            node.put(p[1], node.getOrDefault(p[1], 0) + 1);  
        }
        
        int startNode = pairs[0][0];  
        for(Map.Entry<Integer, Integer> entry : node.entrySet()){
            if(entry.getValue() == -1){
                startNode = entry.getKey();  
                break; 
            }
        }
        
        List<Integer> circuit = new ArrayList<>();
        dfs(graph, startNode, circuit);
        Collections.reverse(circuit); 
        int[][] result = new int[pairs.length][2]; 
        for(int i = 1; i < circuit.size(); i++){
            result[i - 1][0] = circuit.get(i - 1); 
            result[i - 1][1] = circuit.get(i); 
        }
        return result;
    }

    public void dfs(Map<Integer, List<Integer>> graph, int u, List<Integer> res){
        while(graph.containsKey(u) && !graph.get(u).isEmpty()){
            int current = graph.get(u).remove(0);  
            dfs(graph, current, res);  
        }
        res.add(u);
    }
}