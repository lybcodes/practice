package Alibaba;

import java.util.Stack;

/**
 * 判断二叉搜索树（中序遍历迭代写法）
 */
public class Main4 {

    public static class TreeNode {
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

    public static boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        long pre = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = root.left;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            //System.out.println(cur.val);
            if(cur.val <= pre){
                return false;
            }
            pre = cur.val;
            cur = cur.right;
        }
        return true;
    }


    /**
     * 一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值
     */
    static int pre;
    static int ans;
    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        if(pre == -1){
            pre = root.val;
        }else{
            ans = Math.min(ans, Math.abs(root.val - pre));
            pre = root.val;
        }
        inOrder(root.right);
    }
    public static int getMinimumDifference(TreeNode root) {
        pre = -1;
        ans = Integer.MAX_VALUE;
        inOrder(root);
        return ans;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        boolean b = isValidBST(node);

        TreeNode node1 = new TreeNode(543, new TreeNode(384, null, new TreeNode(445)), new TreeNode(652, null, new TreeNode(699)));
        getMinimumDifference(node1);

    }
}
