package wkang.learn;

import java.util.LinkedList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode transfer(int[] num) {
        ListNode head = null;
        for (int i = 0; i < num.length; i++) {
            head = insert(head, num[i]);
        }
        return head;
    }

    public static ListNode insert(ListNode head, int ele) {
        ListNode cur = new ListNode(ele);

        ListNode tmp = head;
        if (head == null) {
            //cur.next = head;
            head = cur;
        } else {
            while (tmp.next != null) {
                tmp = tmp.next;
            }

            tmp.next = cur;
        }
        return head;
    }

    public static void display(ListNode head) {
        ListNode cur = head;
        List<Integer> list = new LinkedList<Integer>();
        while (null != cur) {
            list.add(cur.val);
            cur = cur.next;
        }
        System.out.println("List is : " + list);
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        ListNode head = transfer(num);
        display(head);
    }
}
