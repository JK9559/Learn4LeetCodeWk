package wkang.learn.part0;


import wkang.learn.ListNode;

/**
 * @author kangwei
 * @date 2018/12/7
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * reverseListNode 从pre的下一个起，放到pre之后，返回的ListNode是当前排序组的最后一个节点，是下一组的pre节点
 */
public class Problem025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head || null == head.next || 1 == k) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy, cur = head;
        dummy.next = head;
        int i = 0;
        while (null != cur) {
            ++i;
            if (i % k == 0) {
                pre = reverseListNode(pre, cur.next);
                cur = pre.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;

    }

    public static ListNode reverseListNode(ListNode pre, ListNode next) {
        ListNode last = pre.next;
        ListNode cur = last.next;
        while (cur != next) {
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4};
        Problem025 p = new Problem025();
        //ListNode.display(swapPairs(ListNode.transfer(num)));
        ListNode.display(p.reverseKGroup(ListNode.transfer(num), 2));
    }
}
