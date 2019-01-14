package wkang.learn.part1;

import wkang.learn.TreeNode;

import java.util.HashMap;

/**
 * @author wkang
 * @date 2019/1/9
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Problem105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(map, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }

    private static TreeNode helper(HashMap<Integer, Integer> map, int inLeft, int inRight, int[] preOrder, int preLeft, int preRight) {
        if (inLeft > inRight || preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preLeft]);
        int index = map.get(preOrder[preLeft]);
        root.left = helper(map, inLeft, index - 1, preOrder, preLeft + 1, preLeft + index - inLeft);
        root.right = helper(map, index + 1, inRight, preOrder, preLeft + index - inLeft + 1, preRight);
        return root;
    }

    public static void main(String[] args) {
        int[] in = {9, 3, 15, 20, 7};
        int[] pre = {3, 9, 20, 15, 7};
        Problem105 problem105 = new Problem105();
        TreeNode root = problem105.buildTree(pre, in);
        System.out.println("21");
    }

}
