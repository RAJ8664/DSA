class StockSpanner {
    private Stack<Pair> st;
    static class Pair {
        int price, span;
        public Pair(int price, int span) {
            this.price = price;
            this.span = span;
        }
        @Override
        public String toString() {
            return "(" + price + " " + span + ")";
        }
    }


    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while (st.size() > 0 && st.peek().price <= price) {
            span += st.peek().span;
            st.pop();
        }
        st.add(new Pair(price, span));
        return st.peek().span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */