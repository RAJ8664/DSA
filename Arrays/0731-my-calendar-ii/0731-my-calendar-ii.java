class MyCalendarTwo {
    private TreeMap<Integer, Integer> bookings;
    public MyCalendarTwo() {
        bookings = new TreeMap<>();
    }
    public boolean book(int start, int end) {
        bookings.put(start, bookings.getOrDefault(start, 0) + 1);
        bookings.put(end, bookings.getOrDefault(end, 0) - 1);
        int cnt = 0;
        for (int count : bookings.values()) {
            cnt += count;
            if (cnt >= 3) {
                bookings.put(start, bookings.get(start) - 1);
                if (bookings.get(start) == 0) bookings.remove(start);
                bookings.put(end, bookings.get(end) + 1);
                if (bookings.get(end) == 0) bookings.remove(end);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */