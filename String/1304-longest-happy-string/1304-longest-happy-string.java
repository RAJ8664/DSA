class Solution {
    static class Pair {
        char ch;
        int freq;
        public Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
    static class sorting implements Comparator<Pair> {
        @Override
        public int compare(Pair first, Pair second) {
            return Integer.compare(second.freq, first.freq);
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new sorting());
        if(a > 0) pq.offer(new Pair('a' , a));
        if(b > 0) pq.offer(new Pair('b' , b));
        if(c > 0) pq.offer(new Pair('c' , c));
        String ans = "";
        int a_used = 0 , b_used = 0, c_used = 0;
        while(pq.size() > 0) {
            Pair current = pq.poll();
            if(current.ch == 'a') {
                if(a_used < 2) {
                    ans += "a";
                    current.freq--;
                    a_used++;b_used = 0; c_used = 0;
                    if(current.freq > 0) pq.offer(current);
                }
                else {
                    if(pq.size() == 0) break;
                    Pair current1 = pq.poll();
                    ans += current1.ch;
                    current1.freq--;
                    if(current1.ch == 'a') {
                        a_used++; b_used = 0; c_used = 0;
                    }
                    else if(current1.ch == 'b') {
                        b_used++; a_used = 0; c_used = 0;
                    }
                    else if(current1.ch == 'c') {
                        c_used++; a_used = 0; b_used = 0;
                    }
                    if(current.freq > 0 ) pq.offer(current);
                    if(current1.freq > 0) pq.offer(current1);
                }

            }
            else if(current.ch == 'b') {
                 if(b_used < 2) {
                    ans += "b";
                    current.freq--;
                    b_used++; a_used = 0; c_used = 0;
                    if(current.freq > 0) pq.offer(current);
                }
                else {
                    if(pq.size() == 0) break;
                    Pair current1 = pq.poll();
                    ans += current1.ch;
                    current1.freq--;
                    if(current1.ch == 'a') {
                        a_used++; b_used = 0; c_used = 0;
                    }
                    else if(current1.ch == 'b') {
                        b_used++; a_used = 0; c_used = 0;
                    }
                    else if(current1.ch == 'c') {
                        c_used++; a_used = 0; b_used = 0;
                    }
                    if(current.freq > 0 ) pq.offer(current);
                    if(current1.freq > 0) pq.offer(current1);
                }
            }
            else if(current.ch == 'c') {
                 if(c_used < 2) {
                    ans += "c";
                    current.freq--;
                    c_used++; b_used = 0; a_used = 0;
                    if(current.freq > 0) pq.offer(current);
                }
                else {
                    if(pq.size() == 0) break;
                    Pair current1 = pq.poll();
                    ans += current1.ch;
                    current1.freq--;
                    if(current1.ch == 'a') {
                        a_used++; b_used = 0; c_used = 0;
                    }
                    else if(current1.ch == 'b') {
                        b_used++; a_used = 0; c_used = 0;
                    }
                    else if(current1.ch == 'c') {
                        c_used++; a_used = 0; b_used = 0;
                    }
                    if(current.freq > 0 ) pq.offer(current);
                    if(current1.freq > 0) pq.offer(current1);
                }
            }
        }
        return ans;
    }
}