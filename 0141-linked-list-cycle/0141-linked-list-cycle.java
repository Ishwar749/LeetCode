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

        if(head == null || head.next == null) return false;
        Set<ListNode> set = new HashSet<>();

        set.add(head);

        while(head.next != null) {
            if (set.contains(head.next)) return true;
            set.add(head.next);
            head = head.next;
        }

        return false;
    }
}