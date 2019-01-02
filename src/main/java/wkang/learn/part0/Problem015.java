package wkang.learn.part0;

import wkang.learn.ListNode;

/**
 * @author kangwei
 * @date 2018/12/4
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * �ϲ����� ������һ�������Ѿ�������β�ڵ�ʱ��ֻ��Ҫ����һ�������ָ�����ڽ����
 * ��ԭ��������ʹ��������
 */
public class Problem015 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 1. ����һ��������
        // 2. ��������ָ��ֱ�ָ�����������ͷ���
        // 3. �������һ��Ϊ���ˣ�������ѭ��
        // 4. ѭ���� ȡָ��ָ��Ľڵ��val���Ƚϴ�С��ȡСֵ�������������Ұ�ָ�����
        // 5. ����ѭ�� �жϲ�Ϊ�յ�����������������������
        ListNode pl1 = l1, pl2 = l2, h = null, htail = null;
        if (null == pl1 || null == pl2) {
            h = null == pl1 ? pl2 : pl1;
            return h;
        }

        while (null != pl1 && null != pl2) {
            int val = pl1.val <= pl2.val ? pl1.val : pl2.val;
            if (null == h) {
                h = new ListNode(val);
                h.next = null;
                htail = h;
            } else {
                ListNode tmp = new ListNode(val);
                htail.next = tmp;
                tmp.next = null;
                htail = tmp;
            }
            if (pl1.val <= pl2.val) {
                pl1 = pl1.next;
            } else {
                pl2 = pl2.next;
            }
        }
        htail.next = null == pl1 ? pl2 : pl1;
        return h;
    }

    public static void main(String[] args) {
        int[] num1 = {};
        int[] num2 = {};
        ListNode head1 = ListNode.transfer(num1);
        ListNode.display(head1);
        ListNode head2 = ListNode.transfer(num2);
        ListNode.display(head2);
        ListNode.display(mergeTwoLists(head1, head2));
    }
}
