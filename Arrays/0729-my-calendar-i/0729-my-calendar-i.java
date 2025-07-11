class MyCalendar {
    private ArrayList<Pair> bookings;
    static class Pair {
        int start, end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public String toString() {
            return "(" + start + " " + end + ")";
        }
    }
    public MyCalendar() {
        bookings = new ArrayList<>();
    }
    public boolean book(int start, int end) {
        for (int i = 0; i < bookings.size(); i++) {
            int current_start = bookings.get(i).start;
            int current_end = bookings.get(i).end;
            if (start < current_end && end > current_start) return false;
        }
        bookings.add(new Pair(start, end));
        return true;
    }
}
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
