/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> firstTree = new LinkedList<>();
        Queue<TreeNode> secondTree = new LinkedList<>();
        firstTree.add(p);
        secondTree.add(q);

        while (!firstTree.isEmpty() && !secondTree.isEmpty()) {
            TreeNode firstNode = firstTree.remove();
            TreeNode secondNode = secondTree.remove();

            if (firstNode == null && secondNode == null) {
                continue;
            }

            if (!isIdentical(firstNode, secondNode)) {
                return false;
            }

            firstTree.add(firstNode.left);
            secondTree.add(secondNode.left);
            firstTree.add(firstNode.right);
            secondTree.add(secondNode.right);
        }

        return firstTree.isEmpty() && secondTree.isEmpty();
     }

     private boolean isIdentical(TreeNode firstNode, TreeNode secondNode) {
        if (firstNode != null && secondNode == null) {
            return false;
        }

        if (firstNode == null && secondNode != null) {
            return false;
        }

        if (firstNode.val != secondNode.val) {
            return false;
        }

        return true;
     }
}
