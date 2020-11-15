package Problem1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraverse {
    public static List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        // homework
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> values = new LinkedList<>();          //queue to store integers
        Queue<TreeNode> nodes = new LinkedList<>();         //queue to store unused nodes

        if(root == null){                                   //if empty
            return result;                                  //return null list
        }

        values.add(root.val);           //add root's val to values list
        nodes.add(root);                //add root to nodes queue
        result.add(values);             //add foot's val to result
        values.clear();                 //clear values list

        while(true){                    //loop until line break
            int size = nodes.size();    //size of nodes queue
            if(size == 0)               //break if nodes list is empty
                break;

            for(int i = 0; i < size; i++){          //loop for every node in nodes queue
                TreeNode current = nodes.poll();    //(temp) current node is head in nodes, remove head from nodes
                                                    //the queue allows each level to be stored then the loop
                                                    //can traverse through each level while removing used nodes

                if(current.left != null){           //if left is not empty
                    nodes.add(current.left);        //add left to nodes
                }

                if(current.right != null){          //if right is not empty
                    nodes.add(current.right);       //add right to nodes
                }
            }

            for(TreeNode item : nodes){             //fill in values list
                values.add((int)item.val);          //the while loop should gather each level of
                                                    //nodes into the nodes queue
            }

            result.add(values);                             //put values list in result list
            values.clear();                                 //clear values list
        }

        return result;  // place holder
    }
}
