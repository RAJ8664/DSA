class FrontMiddleBackQueue {
    private ArrayList<Integer> dq;
    public FrontMiddleBackQueue() {
        dq = new ArrayList<>();
    }

    public void pushFront(int val) {
        dq.add(0, val);
    }

    public void pushMiddle(int val) {
        dq.add(dq.size() / 2, val);
    }

    public void pushBack(int val) {
        dq.add(dq.size(), val);
    }

    public int popFront() {
        if (dq.size() == 0) return - 1;
        return dq.remove(0);
    }

    public int popMiddle() {
        if (dq.size() == 0) return -1;
        return dq.remove((dq.size() - 1) / 2);
    }

    public int popBack() {
        if (dq.size() == 0) return -1;
        return dq.remove(dq.size() - 1);
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */