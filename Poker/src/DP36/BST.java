package DP36;

/**
 * 在二叉搜索树中找最小的大于某个key值的节点
 */
public class BST {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    //递归实现
    TreeNode findCeiling(TreeNode root, int key){
        if(root == null){
            return null;
        }
        if(root.val <= key){
            return findCeiling(root.right, key);
        }else{
            TreeNode ceiling = findCeiling(root.left, key);
            return ceiling == null ? root : ceiling;
        }
    }

//    //迭代实现
//    TreeNode findCeiling(TreeNode root, int key){
//        TreeNode ceiling = null;
//        TreeNode cur = root;
//        while(cur != null){
//            if(cur.val <= key) {
//                cur = cur.right;
//            }else{
//                ceiling = cur;
//                cur = cur.left;
//            }
//        }
//        return ceiling;
//    }
}
