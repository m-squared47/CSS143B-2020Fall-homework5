package ExtraCredit;

import Problem1.TreeNode;
import Problem1.InOrderTraverse;

import java.util.ArrayList;
import java.util.List;

public class KDistance {
    public static List<Integer> distanceK(TreeNode<Integer> root, TreeNode<Integer> target, int k) {
        // homework
        //return all values that are "k" distance from the "target" of binary search tree "root"

        //result arraylist
        List<Integer> result = new ArrayList<>();

        //base case (root is null)
        if(root == null)
            return null;

        //alt base case (target found)
        if(root.val == target.val){
            findValues(root, k, result);
        }

        //continue finding the target going to left and right sub trees
        List<Integer> left = distanceK(root.left, target, k);
        List<Integer> right = distanceK(root.right, target, k);

        //if left has values
        if(left != null){

            for(int item : left){   //add values to result
                result.add(item);
            }
        }

        //if left has no values and right has values
        if(right != null){

            for(int item : right){  //add values to result
                result.add(item);
            }
        }

        return result;  // place holder
    }

    /**
     * Finds the values at distance k
     * @param root
     * @param distance
     */
    private static void findValues(TreeNode<Integer> root, int k, List<Integer> result){
        if(root == null)            //base case (empty)
            return;

        if(k == 0){                  //alt base case (value found)
            result.add(root.val);
            return;
        }

        findValues(root.left, k - 1, result);   //if k is not 0, go left and right
        findValues(root.right, k -1, result);
    }
}
