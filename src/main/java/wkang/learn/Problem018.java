package wkang.learn;

/**
 * @author kangwei
 * @date 2018/12/7
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * 两两交换 换过的不再交换
 */
public class Problem018 {

    public ListNode swapPairs(ListNode head) {
        ListNode pleft, pright, preleft;
        if (null == head || null == head.next) {
            return head;
        }
        preleft = null;
        pleft = head;
        pright = head.next;
        while (null != pleft && null != pright) {
            if (null == preleft) {
                head = pright;
                pleft.next = pright.next;
                pright.next = pleft;
            } else {
                preleft.next = pright;
                pleft.next = pright.next;
                pright.next = pleft;
            }
            preleft = pleft;
            pleft = preleft.next;
            pright = null == pleft ? null : pleft.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] lst = {1, 2, 3};
        Problem018 p8 = new Problem018();
        ListNode.display(p8.swapPairs(ListNode.transfer(lst)));
    }
}
