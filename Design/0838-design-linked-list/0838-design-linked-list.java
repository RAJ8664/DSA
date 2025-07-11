class MyLinkedList {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            next = null;
        }
    }
    private Node head;
    public MyLinkedList() {
        head = null;
    }
    public int get(int index) {
        if (index >= getSize()) return -1;
        int current_ind = 0;
        Node temp = head;
        while (current_ind != index) {
            temp = temp.next;
            current_ind++;
        }
        return temp.data;
    }
    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }
        Node New_Node = new Node(val);
        New_Node.next = head;
        head = New_Node;
    }
    public void addAtTail(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }
        Node Temp = head;
        while (Temp.next != null) {
            Temp = Temp.next;
        }
        Node New_Node = new Node(val);
        Temp.next = New_Node;
        New_Node.next = null;
    }
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == getSize()) {
            addAtTail(val);
            return;
        }
        if (index > getSize()) return;
        int current_ind = 0;
        Node prev = head;
        Node next = head;
        while (current_ind != index) {
            prev = next;
            next = next.next;
            current_ind++;
        }
        Node New_Node = new Node(val);
        prev.next = New_Node;
        New_Node.next = next;
    }
    public void deleteAtIndex(int index) {
        if (index == 0 && head == null) return;
        if (index == 0) {
            head = head.next;
            return;
        }
        if (index >= getSize()) return;
        int current_ind = 0;
        Node prev = head;
        Node next = head;
        while (current_ind != index) {
            prev = next;
            next = next.next;
            current_ind++;
        }
        prev.next = next.next;
    }
    private int getSize() {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
