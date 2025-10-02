class Solution {
    public String clearStars(String s) {
        int n = s.length();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new sorting());
        HashSet<Integer> deleted = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) != '*') {
                pq.offer(new Pair(s.charAt(i) , i));
            }
            else {
                if(pq.size() == 0) continue;
                deleted.add(pq.peek().ind);
                pq.poll();
            }
        }

        String ans = "";
        for(int i = 0; i < n; i++) {
            if(!deleted.contains(i) && s.charAt(i) != '*') {
                ans += s.charAt(i);
            }
        }
        return ans;
    }

    static class Pair {
        char ch;
        int ind;
        public Pair(char ch, int ind) {
            this.ch = ch;
            this.ind = ind;
        }
    }

    static class sorting implements Comparator<Pair> {
        @Override
        public int compare(Pair first, Pair second) {
            int op1 = Integer.compare(first.ch, second.ch);
            if(op1 != 0) return op1;
            return Integer.compare(second.ind , first.ind);
        }
    }
}