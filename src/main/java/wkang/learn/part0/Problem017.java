package wkang.learn.part0;

import wkang.learn.ListNode;

/**
 * @author kangwei
 * @date 2018/12/5
 * https://leetcode.com/problems/merge-k-sorted-lists
 * min heap
 */
public class Problem017 {
    /**
     * 使用最小堆实现
     */
    int maxLen = 16;
    int lastIndex = 0;
    int[] heapArray = new int[maxLen];

    Problem017() {
        for (int i = 0; i < heapArray.length; i++) {
            heapArray[i] = Integer.MIN_VALUE;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int maxNum = 0;
        for (int i = 0; i < lists.length; i++) {
            ListNode plist = lists[i];
            while (null != plist) {
                shiftUp(plist.val);
                plist = plist.next;
                maxNum++;
            }
        }
        ListNode res = null;
        ListNode pres = null;
        for (int i = 0; i < maxNum; i++) {
            ListNode tmp = new ListNode(popTop());
            tmp.next = null;
            if (null == res) {
                res = tmp;
                pres = res;
            } else {
                pres.next = tmp;
                pres = pres.next;
            }
        }
        return res;
    }

    public void shiftUp(int key) {
        // min top heap
        if (lastIndex + 1 >= maxLen) {
            int[] tmpArray = new int[maxLen * 2];
            for (int i = 0; i < tmpArray.length; i++) {
                tmpArray[i] = Integer.MIN_VALUE;
            }
            System.arraycopy(heapArray, 0, tmpArray, 0, lastIndex + 1);
            heapArray = tmpArray;
            maxLen *= 2;
        }
        heapArray[++lastIndex] = key;
        int curIndex = lastIndex;
        int parent = curIndex / 2;
        while (heapArray[parent] > heapArray[curIndex]) {
            int tmp = heapArray[parent];
            heapArray[parent] = heapArray[curIndex];
            heapArray[curIndex] = tmp;
            curIndex = parent;
            parent = curIndex / 2;
        }
    }

    public void shiftDown() {
        int startIndex = 1;
        int leftIndex = startIndex * 2;
        int rightIndex = startIndex * 2 + 1;
        while (leftIndex <= lastIndex && (heapArray[startIndex] > heapArray[leftIndex] || heapArray[startIndex] > heapArray[rightIndex])) {
            int tmpIndex = heapArray[leftIndex] < heapArray[rightIndex] ? leftIndex : rightIndex;
            int tmp = heapArray[tmpIndex];
            heapArray[tmpIndex] = heapArray[startIndex];
            heapArray[startIndex] = tmp;
            startIndex = tmpIndex;
            leftIndex = startIndex * 2;
            rightIndex = startIndex * 2 + 1;
        }
    }

    public int popTop() {
        int top = heapArray[1];
        heapArray[1] = heapArray[lastIndex--];
        shiftDown();
        return top;
    }

    public static void main(String[] args) {
        int[] l1 = {2};
        int[] l2 = {};
        int[] l3 = {-1};
        ListNode.transfer(l1);
        ListNode[] lists = {ListNode.transfer(l1),ListNode.transfer(l2),ListNode.transfer(l3)};
        Problem017 p = new Problem017();
        ListNode.display(p.mergeKLists(lists));
    }
}
