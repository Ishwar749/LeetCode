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
        List<Integer> vals = new ArrayList<>();

        while(head != null) {
            vals.add(head.val);
            head = head.next;
        }

        int maxSum = 0;
        int size = vals.size();

        for(int i = 0; i < (size / 2); i++) {
            maxSum = Math.max(maxSum, vals.get(i) + vals.get(size - 1 - i));
        }

        return maxSum;
    }
}