/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> nodes = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            nodes.add(current.val);
            current = current.next;
        }
        Stack<Integer> st = new Stack<>();
        int res[] = new int[nodes.size()];
        for (int i = nodes.size() - 1; i >= 0; i--) {
            int curr = nodes.get(i);
            while (st.size() > 0 && st.peek() <= curr) st.pop();
            if (st.size() == 0) res[i] = 0;
            else res[i] = st.peek();
            st.add(curr);
        }
        return res;
    }
}