/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        int flagValue = 1000000;
        head.val = flagValue;

        while (head.next != null) {
            if (head.next.val == flagValue) return true;
            head = head.next;
            head.val = flagValue;
        }

        return false;
    }
}