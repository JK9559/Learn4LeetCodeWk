package wkang.learn.part0;


import wkang.learn.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * @date 2019/02/12
 * @author wkang
 */
public class Problem002 {

    /**
     * @param l1 输入数字链表l1
     * @param l2 输入数字链表l2
     * @return 返回结果链表ret
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode cur = ret;
        int sum = 0;
        while (true) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.val = sum % 10;
            sum = sum / 10;
            /*
            * 注意判断跳出条件 当l1和l2的next都为空并且和(sum)为0时 终止循环
            * */
            if (l1 != null || l2 != null || sum != 0) {
                cur.next = new ListNode(0);
                cur = cur.next;
            }else {
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}
