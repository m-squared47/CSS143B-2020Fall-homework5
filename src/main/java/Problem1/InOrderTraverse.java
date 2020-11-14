package Problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraverse {
    public static List<Integer> inorderTraversalIterative(TreeNode<Integer> root) {
        // homework
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();       //records previous nodes

        if(root == null)                                //if tree is empty
            return result;

        if(root.left == null && root.right == null){    //if tree has one element
            result.add(root.val);
            return result;
        }

        while(root != null || nodes.size() > 0){        //go through tree

            while(root != null){                        //transverse through leftmost branch
                nodes.push(root);                       //push current node
                root = root.left;                       //traverse left
            }

            root = nodes.pop();                         //get last non-null element
            result.add(root.val);                       //push current value
            root = root.right;                          //traverse right
        }

        return result;
    }
}
