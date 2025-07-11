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
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int ele : nums) set.add(ele);
        ListNode temp = head;
        int count = 0, current_element_count = 0;
        while (temp != null) {
            if (set.size() == 0) break;
            int current_ele = temp.val;
            if (set.contains(current_ele)) {
                set.remove(current_ele);
                current_element_count++;
            }
            else if(current_element_count > 0) {
                count++;
                set.remove(current_ele);
                current_element_count = 0;
            }
            temp = temp.next;
        }
        count++;
        return count;
    }
}