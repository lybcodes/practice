package DP36.pathSum;

import java.util.ArrayList;
import java.util.List;

//回溯 本质上是深度优先遍历
//回溯 一般把问题抽象称一棵树 然后穷举所有情况
public class lc113 {
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, res, path);
        return res;
    }
    private void dfs(TreeNode node,
                     int parentNodeTarget,
                     List<List<Integer>> res,
                     List<Integer> path){
        if(node == null) return;
        path.add(node.val);
        int curNodeTarget = parentNodeTarget - node.val;
        if(node.left == null && node.right == null && curNodeTarget == 0){
            res.add(new ArrayList<>(path));
        }
        dfs(node.left, curNodeTarget, res, path);
        dfs(node.right, curNodeTarget, res, path);
        //回溯过程中将当前节点删掉
        path.remove(path.size() - 1);
    }

}
