package Problem3;

import Problem1.TreeNode;

public class InsertInBST {
    public static void insert(TreeNode<Integer> root, int valToInsert) {
        // homework
        //inserts in a null position
        //left is <=, right >

        //uses helper function to return a TreeNode object
        root = insertRecursive(root, valToInsert);
    }

    private static TreeNode<Integer> insertRecursive(TreeNode<Integer> root, int valToInsert){
        if(root == null){                           //if the root is null, insert and return to base
            root = new TreeNode<>(valToInsert);
            return root;                            //new pointer is created, recursion is finished
        }

        if(root.val >= valToInsert)                             //if value is less than or equal to the root, go left
            root.left = insertRecursive(root.left, valToInsert);//left branch points to result of recursion

        if(root.val < valToInsert)                                  //value is greater than the root, go right
            root.right = insertRecursive(root.right, valToInsert);  //right branch points to result of recursion

        return root;    //go back to base root, return the base root
    }
}
