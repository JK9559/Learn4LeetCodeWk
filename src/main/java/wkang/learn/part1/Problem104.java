package wkang.learn.part1;

import wkang.learn.TreeNode;

import java.util.LinkedList;

/**
 * @author wkang
 * @date 2019/1/14
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class Problem104 {
    public int maxDepth(TreeNode root) {
        return null == root ? 0 : (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
    }


    public int maxDepthByQueue(TreeNode root) {
        if (null == root) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] in = {1, 2, 3};
        int[] post = {1, 3, 2};

        TreeNode root = TreeNode.buildTree(in, post);

        System.out.println(new Problem104().maxDepth(root));
        System.out.println(new Problem104().maxDepthByQueue(root));
    }
}
