import Problem1.TreeNode;
import Problem3.InsertInBST;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Problem3Test {
    public static class BSTTestCase<T> {
        final TreeNode<T> tree;
        final int valueToInsert;
        final List<T> expect;

        public BSTTestCase(TreeNode<T> tree, int valueToInsert, List<T> expect) {
            this.tree = tree;
            this.valueToInsert = valueToInsert;
            this.expect = expect;
        }
    }

    @Test
    public void testInsertBST() {
        List<BSTTestCase<Integer>> testCases = getBSTTestCases();

        for (BSTTestCase<Integer> testCase : testCases) {
            InsertInBST.insert(testCase.tree, testCase.valueToInsert);
            List<Integer> actual = inOrderTraverse(testCase.tree);
            assertEquals(testCase.expect, actual);
        }
    }

    @Test
    public void testInOrderTraverse() {
        //homework
        // to verify inOrderTraverse(TreeNode<Integer> node)
        //test if the size of the output array is the same as the input
        List<TreeNode<Integer>> testTrees = new ArrayList<>();  //list of input testing trees
        int[][] treesArray = {
                {5, 4, 5, 7, 6, 2, 3},
                {2, 1, 5, 4, 6},
                {10, 5, 9, 8, 12, 15, 13}
        };

        List<List<Integer>> expectedList = new ArrayList<>();
        expectedList.add(Arrays.asList(2, 3, 4, 5, 5, 6, 7));       //tree 1 expected
        expectedList.add(Arrays.asList(1, 2, 4, 5, 6));             //tree 2 expected
        expectedList.add(Arrays.asList(5, 8, 9, 10, 12, 13, 15));   //tree 3 expected

        for(int i = 0; i < treesArray.length; i++) {            //for every test case

            TreeNode<Integer> tree = null;                      //fill in test tree
            for(int j = 0; j < treesArray[i].length; j++){
                if(j == 0){                                     //main root
                    tree = new TreeNode<>(treesArray[i][0]);
                }else {
                    InsertInBST.insert(tree, treesArray[i][j]); //insert
                }
            }

            List<Integer> actual = inOrderTraverse(tree);       //test tree to list
            List<Integer> expected = expectedList.get(i);       //get expected list

            for (int g = 0; g < expected.size(); g++) {         //test if elements are the same
                assertEquals("Tree: " + i + " Case: " + g,expected.get(g), actual.get(g));
            }

            assertEquals(expected.size(), actual.size());       //check if both arrays are the same size
        }
    }

    private static List<Integer> inOrderTraverse(TreeNode<Integer> node) {
        List<Integer> result = new ArrayList<>();
        inOrderTraverse(node, result);
        return result;
    }

    private static void inOrderTraverse(TreeNode<Integer> node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.left, result);
        result.add(node.val);
        inOrderTraverse(node.right, result);
    }


    private List<BSTTestCase<Integer>> getBSTTestCases() {
        List<BSTTestCase<Integer>> testCases = new ArrayList<>();

        //      1
        //     / \
        //    N   N
        testCases.add(new BSTTestCase<>(new TreeNode<>(1), 0, Arrays.asList(0, 1)));

        //      1
        //     / \
        //    N   N
        testCases.add(new BSTTestCase<>(new TreeNode<>(1), 1, Arrays.asList(1, 1)));

        //      1
        //     / \
        //    N   N
        testCases.add(new BSTTestCase<>(new TreeNode<>(1), 2, Arrays.asList(1, 2)));

        //      2
        //     / \
        //    1   N
        TreeNode<Integer> root = new TreeNode<>(2);
        root.left = new TreeNode<>(1);
        testCases.add(new BSTTestCase<>(root, 3, Arrays.asList(1, 2, 3)));

        //      2
        //     / \
        //    1   N
        root = new TreeNode<>(2);
        root.left = new TreeNode<>(1);
        testCases.add(new BSTTestCase<>(root, 3, Arrays.asList(1, 2, 3)));

        //      2
        //     / \
        //    1   N
        root = new TreeNode<>(2);
        root.left = new TreeNode<>(1);
        testCases.add(new BSTTestCase<>(root, 0, Arrays.asList(0, 1, 2)));

        //      4
        //     / \
        //    2   6
        root = new TreeNode<>(4);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(6);
        testCases.add(new BSTTestCase<>(root, 1, Arrays.asList(1, 2, 4, 6)));

        //      4
        //     / \
        //    2   6
        root = new TreeNode<>(4);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(6);
        testCases.add(new BSTTestCase<>(root, 3, Arrays.asList(2, 3, 4, 6)));

        //      4
        //     / \
        //    2   6
        root = new TreeNode<>(4);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(6);
        testCases.add(new BSTTestCase<>(root, 5, Arrays.asList(2, 4, 5, 6)));

        //      4
        //     / \
        //    2   6
        root = new TreeNode<>(4);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(6);
        testCases.add(new BSTTestCase<>(root, 7, Arrays.asList(2, 4, 6, 7)));

        //      9
        //     / \
        //    5   10
        //   / \   \
        //  3   6   13
        root = new TreeNode<>(9);
        root.left = new TreeNode<>(5);
        root.left.left = new TreeNode<>(3);
        root.left.right = new TreeNode<>(6);
        root.right = new TreeNode<>(10);
        root.right.right = new TreeNode<>(13);
        testCases.add(new BSTTestCase<>(root, 4, Arrays.asList(3, 4, 5, 6, 9, 10, 13)));
        testCases.add(new BSTTestCase<>(root, 11, Arrays.asList(3, 4, 5, 6, 9, 10, 11, 13)));
        testCases.add(new BSTTestCase<>(root, 2, Arrays.asList(2, 3, 4, 5, 6, 9, 10, 11, 13)));
        testCases.add(new BSTTestCase<>(root, 15, Arrays.asList(2, 3, 4, 5, 6, 9, 10, 11, 13, 15)));

        //      1
        //     / \
        //    N   N
        // homework
        // what problem can you see for insertInBst from this test case?
        // answer: Since 1 is a very low value and all the inserted values are in numerical order,
        //          this tree will just become a right branch linked list making this list very inefficient to
        //          search through as it gets longer. A balanced tree is very efficient to search through as trees
        //          can be split in half exponentially, but the problem with binary trees is that they get more
        //          and more inefficient the more lopsided they get.
        // discuss how you would solve it in a comment below
        // answer: Given a sorted array, you can find the middle value and use that as the root and split the array
        //          in half. Then you continue taking the middle values of those arrays and inserting those values
        //          into the tree while splitting those arrays in half until they are one element (more recursion).
        //          This will ensure both sides have the same number of elements (or -1 if odd). This does get more
        //          inefficient as the number of elements increases, as most things often do. When inserting and element,
        //          you can do an in order traverse and put all the values into an array. Insert the new element in the
        //          array in a sorted manner, then put back in the tree again. But this method get even more inefficient
        //          the more elements you have, but searching through the tree will still be more efficient than before.
        root = new TreeNode<>(1);
        testCases.add(new BSTTestCase<>(root, 2, Arrays.asList(1, 2)));
        testCases.add(new BSTTestCase<>(root, 3, Arrays.asList(1, 2, 3)));
        testCases.add(new BSTTestCase<>(root, 4, Arrays.asList(1, 2, 3, 4)));
        testCases.add(new BSTTestCase<>(root, 5, Arrays.asList(1, 2, 3, 4, 5)));

        return testCases;
    }
}