package wkang.learn;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
    }

    public static ListNode insert(ListNode head,int ele){
        ListNode cur = new ListNode(ele);

        ListNode tmp = head;
        if(head == null){
            //cur.next = head;
            head = cur;
        }else {
            while (tmp.next != null){
                tmp = tmp.next;
            }

            tmp.next = cur;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] num = {3,4,5};
        ListNode head = null;
        for (int i = 0; i < num.length; i++){
            head = insert(head,num[i]);
        }
        ListNode cur = head;
        while (cur != null){
            System.out.println(cur.val + ",");
            cur = cur.next;
        }
    }
}
