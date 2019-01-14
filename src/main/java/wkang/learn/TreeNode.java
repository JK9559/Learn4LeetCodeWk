package wkang.learn;

import java.util.HashMap;

/**
 * @author wkang
 * @date 2019/1/2
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }


    /**
     * @param inorder   中序遍历数组
     * @param postorder 后序遍历数组
     * @return 新建树的根节点
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (null == inorder || null == postorder || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(map, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static TreeNode helper(HashMap<Integer, Integer> map, int inLeft, int inRight, int[] postOrder, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[postRight]);
        int index = map.get(postOrder[postRight]);
        root.left = helper(map, inLeft, index - 1, postOrder, postLeft, postLeft + index - 1 - inLeft);
        root.right = helper(map, index + 1, inRight, postOrder, postLeft + index - inLeft, postRight - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] in = {11, 4, 5, 13, 8, 9};
        int[] post = {11, 4, 13, 9, 8, 5};
        TreeNode root = buildTree(in, post);
        System.out.println("21");
    }

}
