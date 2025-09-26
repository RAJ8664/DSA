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
    public ListNode doubleIt(ListNode head) {
        String current = "";
        ListNode temp = head;
        while (temp != null) {
            current += temp.val;
            temp = temp.next;
        }
        String dummy = current, res = "";
        int carry = 0;
        for (int i = current.length() - 1; i >= 0; i--) {
            int first = current.charAt(i) - '0';
            int second = dummy.charAt(i) - '0';
            int dig = first + second + carry;
            if (i == 0) {
                res = dig + (res);
                continue;
            }
            if (dig >= 10) {
                res = (dig % 10) + res;
                carry = dig / 10;
            }
            else {
                res = dig + res;
                carry = 0;
            }
        }

        ListNode answer_node = null;
        for (int i = res.length() - 1; i >= 0; i--) {
            int current_data = res.charAt(i) - '0';
            answer_node = insert(answer_node, current_data);
        }
        return answer_node;
    }

    private ListNode insert(ListNode head, int data) {
        ListNode to_insert = new ListNode(data);
        if (head == null) return new ListNode(data);
        to_insert.next = head;
        head = to_insert;
        return head;
    }
}