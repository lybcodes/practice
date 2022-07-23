package DP36.pathSum;
//回溯 本质上是深度优先遍历
//回溯 一般把问题抽象称一棵树 然后穷举所有情况
public class lc112 {
    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }
    private boolean dfs(TreeNode root, int targetSum){
        if(root == null) return false;
        if(root.left == null && root.right == null){
            return targetSum - root.val == 0;
        }
        return dfs(root.left, targetSum - root.val) || dfs(root.right, targetSum - root.val);
    }

}
