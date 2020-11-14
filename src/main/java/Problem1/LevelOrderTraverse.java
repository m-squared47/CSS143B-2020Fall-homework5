package Problem1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraverse {
    public static List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        // homework
        List<List<Integer>> result = new ArrayList<>();
        Queue<Integer> values = new LinkedList<>();         //queue to store integers
        Queue<TreeNode> nodes = new LinkedList<>();         //queue to store unused nodes

        if(root == null){                                   //if empty
            return result;
        }

        values.add(root.val);       //add root's value to queue
        nodes.add(root);            //add root to queue

        while(true){                    //loop until line break
            int size = nodes.size();    //size of nodes queue
            if(size == 0)               //break if nodes list is empty
                break;

            while(size != 0){
                TreeNode current = nodes.peek();    //(temp) current node is head in nodes
                                                    //the queue allows each level to be stored then the loop
                                                    //can traverse through each level while removing used nodes
                nodes.remove();                     //remove head

                if(current.left != null){           //if left is not empty
                    nodes.add(current.left);        //add left to nodes
                }

                if(current.right != null){          //if right is not empty
                    nodes.add(current.right);       //add right to nodes
                }

                size--;                             //decrement size for this loop
            }

            for(TreeNode item : nodes){             //fill in values list
                values.add(item.val);
            }


        }

        return result;  // place holder
    }
}
