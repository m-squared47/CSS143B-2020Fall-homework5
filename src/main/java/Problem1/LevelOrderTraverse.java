package Problem1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraverse {
    public static List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        // homework
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> values = new ArrayList<>();          //list to store integers
        Queue<TreeNode> nodes = new LinkedList<>();         //queue to store unused nodes
                                                            //I used linked list with the Queue interface
                                                            //because it's easier for me to keep track of
                                                            //and I can take out the oldest element in the list
                                                            //this reason is important for later

        nodes.add(root);                                    //add root to nodes queue
        while(!nodes.isEmpty() && root != null){            //while the nodes queue is not empty and a BST exists
            int size = nodes.size();                        //size of nodes queue for this iteration

            while(size > 0) {
                TreeNode<Integer> hold = nodes.poll();      //set hold to first node, remove from nodes queue
                values.add(hold.val);                       //add value to the values list

                //check left, add branch to the queue if it exists
                if (hold.left != null) {
                    nodes.add(hold.left);
                }

                //check right, add branch to the queue if it exists
                if (hold.right != null) {
                    nodes.add(hold.right);
                }

                size--;     //tells how long the loop should last
            }

            result.add(new ArrayList<>(values));    //add this level of values to the result
            values.clear();                         //clear for next level of values
        }

        return result;  // return all levels of values
    }
}
