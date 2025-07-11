class MyCircularDeque {
    private Deque<Integer> dq;
    private int len;
    public MyCircularDeque(int k) {
        dq = new ArrayDeque<>();
        this.len = k;
    }
    public boolean insertFront(int value) {
        if (dq.size() == len) return false;
        dq.addFirst(value);
        return true;
    }
    public boolean insertLast(int value) {
        if (dq.size() == len) return false;
        dq.addLast(value);
        return true;
    }
    public boolean deleteFront() {
        if (dq.size() == 0) return false;
        dq.pollFirst();
        return true;
    }
    public boolean deleteLast() {
        if (dq.size() == 0) return false;
        dq.pollLast();
        return true;
    }
    public int getFront() {
        if (dq.size() == 0) return -1;
        return dq.peekFirst();
    }
    public int getRear() {
        if (dq.size() == 0) return -1;
        return dq.peekLast();
    }
    public boolean isEmpty() {
        return dq.size() == 0;
    }
    public boolean isFull() {
        return dq.size() == len;
    }
}
/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
