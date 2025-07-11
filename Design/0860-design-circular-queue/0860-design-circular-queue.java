class MyCircularQueue {
    private Deque<Integer> dq;
    private int len;
    public MyCircularQueue(int k) {
        this.len = k;
        dq = new ArrayDeque<>();
    }
    public boolean enQueue(int value) {
        if (dq.size() == len) return false;
        dq.addLast(value);
        return true;
    }
    public boolean deQueue() {
        if (dq.size() == 0) return false;
        dq.pollFirst();
        return true;
    }
    public int Front() {
        if (dq.size() == 0) return -1;
        return dq.peekFirst();
    }
    public int Rear() {
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
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
