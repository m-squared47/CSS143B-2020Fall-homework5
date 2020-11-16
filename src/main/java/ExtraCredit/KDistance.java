package ExtraCredit;

import Problem1.TreeNode;
import Problem1.InOrderTraverse;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KDistance {
    public static List<Integer> distanceK(TreeNode<Integer> root, TreeNode<Integer> target, int k) {
        // homework
        //return all values that are "k" distance from the "target" of binary search tree "root"

        List<Integer> result = new ArrayList<>();   //result integer list

        if(root == null)                            //base case (empty)
            return null;

        if(root.val == target.val){                 //base case (root is target)
            findKLower(root, k, result);
        }

        TreeNode<Integer> start = findTarget(root, target); //find the target node
        findKLower(start, k, result);                       //find integer values from target node

        return result;                              // final result array
    }

    /**
     * Finding values lower than the target
     * @param start
     * @param k
     * @return
     */
    private static void findKLower(TreeNode<Integer> start, int k, List<Integer> result){
        if(start == null || k < 0)                  //base case (empty)
            return;

        if(k == 0){                                 //base case (k is reached)
            result.add(start.val);
            return;
        }

        //recurse left and right, decrementing k
        findKLower(start.left, k - 1, result);
        findKLower(start.right, k - 1, result);
    }

    /**
     * Finds the node that matches the target
     * @param root
     * @param target
     * @return
     */
    private static TreeNode<Integer> findTarget(TreeNode<Integer> root, TreeNode<Integer> target){
        if(root == null)                //base case (end of tree)
            return null;

        if(root.val == target.val)      //base case (target found)
            return root;

        //go left and right
        TreeNode<Integer> left = findTarget(root.left, target);
        TreeNode<Integer> right = findTarget(root.right, target);

        //return if not null
        if(left != null)
            return left;

        if(right != null)
            return right;

        return null;    //if all cases fail (target not found)
    }

    /**
     * Finds the minimum distance between the root and the target node
     * @param root
     * @param target
     * @return
     */
    private static int rootToTarget(TreeNode<Integer> root, TreeNode<Integer> target, int distance){
        if(root == null)                //base case (empty or does not exist)
            return -1;

        if(root.val == target.val)      //base case (target found)
            return distance;

        int left = rootToTarget(root, target, distance + 1);
        int right = rootToTarget(root, target, distance + 1);

        if(left != -1)
            return left;

        if(right != -1)
            return right;

        return - 1;
    }
}
