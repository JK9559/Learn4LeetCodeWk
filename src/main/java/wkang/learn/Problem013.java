package wkang.learn;

import wkang.learn.ListNode;

/**
 * @author kangwei
 * @date 2018/11/30
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * ά������ָ�� ��һ��ָ���һ���ڵ㣬�ڶ���ָ���ͷ����n���ڵ㣬���ڶ���ָ��ָ�����һ������ʱ
 * ɾ����һ��ָ��ָ��Ľڵ㡣
 * ע�⣺ɾ��ͷ�ڵ� {1},1 ����Case
 */
public class Problem013 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l, r, tmp = null, htmp;
        l = r = head;
        int i = 1;
        while (null != r.next && i < n) {
            r = r.next;
            i++;
        }
        while (null != r.next) {
            tmp = l;
            r = r.next;
            l = l.next;
        }
        if (null != tmp) {
            tmp.next = l.next;
            l.next = null;
        } else {
            htmp = head;
            head = head.next;
            htmp.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5};
        ListNode head = null;
        for (int i = 0; i < num.length; i++) {
            head = ListNode.insert(head, num[i]);
        }

        ListNode cur;
        ListNode h = removeNthFromEnd(head, 2);

        cur = h;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
