package Problem2;

import Problem1.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LCA {
    public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        // homework
        // hint: pay attention to the assumptions of this problem.

        //if root is null
        //this should not be the case assuming p and q can be found in the root tree
        if(root == null)
            return null;

        //if root equals an input, return this root
        if(root.val == p.val || root.val == q.val)
            return root;

        //recursion to check each node in the tree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //if left and right have a node, return this root
        if(left != null && right != null)
            return root;

        //if only right has a node, return root of right
        if(right != null)
            return right;

        //else, return root of left
        return left;
    } 
}
