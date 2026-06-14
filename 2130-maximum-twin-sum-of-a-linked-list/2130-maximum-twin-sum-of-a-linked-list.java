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
    public int pairSum(ListNode head) {
        Stack<Integer> vals = new Stack<>();

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            vals.push(slow.val);
        }
        
        slow = slow.next;

        int maxSum = 0;

        while(slow != null) {
            maxSum = Math.max(maxSum, vals.pop() + slow.val);
            slow = slow.next;            
        }

        return maxSum;
    }
}