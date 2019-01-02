package wkang.learn.part0;

import wkang.learn.ListNode;

/**
 * @author kangwei
 * @date 2018/12/4
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 合并链表 当其中一个链表已经遍历到尾节点时，只需要将另一个链表的指都放在结果里
 * 用原有链表还是使用新链表
 */
public class Problem015 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 1. 创建一个新链表
        // 2. 定义两个指针分别指向两个链表的头结点
        // 3. 如果链表一个为空了，则跳出循环
        // 4. 循环内 取指针指向的节点的val，比较大小，取小值放入新链表，并且把指针后移
        // 5. 跳出循环 判断不为空的链表，遍历插入新链表，返回
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
