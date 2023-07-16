import java.util.*;

//import javax.swing.tree.TreeNode;

public class BST {

    public static void main(String[] args) {
        BST bst = new BST();
        int n, num, i;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("How many numbers you want to insert.");
            n = sc.nextInt();
            System.out.println("Enter " + n + " numbers.");
            for (i = 0; i < n; i++) {
                num = sc.nextInt();
                bst.InsertIntoTree(num);
            }
            System.out.println("Tree Insertion Done.");
            System.out.println("Enter the number you want to search.");
            n = sc.nextInt();
        }
        if (bst.searchTree(n) == null)
            System.out.println("Number not found.");
        else
            System.out.println("Number found.");

        System.out.println("Pre-Order Traversal of Binary Search Tree");
        bst.preOrderTraversal();

        System.out.println("\nIn-Order Traversal of Binary Search Tree");
        bst.inOrderTraversal();

        System.out.println("\nPost-Order Traversal of Binary Search Tree");
        bst.postOrderTraversal();

    }

    public class TreeNode { // Declaration of BST
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }

    }

    TreeNode root;

    BST() {
        root = null;
    } // Declaration of BST (end)

    public TreeNode insert(TreeNode root, int dataToBeInserted) // Insertion in BST
    {
        if (root == null) {
            root = new TreeNode(dataToBeInserted);
            return root;
        }

        if (root.data > dataToBeInserted) {
            root.left = insert(root.left, dataToBeInserted);
        }

        else if (root.data < dataToBeInserted) {
            root.right = insert(root.right, dataToBeInserted);
        }

        return root;
    } // Insertion in BST (End)

    public TreeNode search(TreeNode root, int dataToBeInserted) // Searching in BST
    {
        if (root == null || root.data == dataToBeInserted)
            return root;

        if (root.data > dataToBeInserted)
            return search(root.left, dataToBeInserted);

        else
            return search(root.right, dataToBeInserted);
    } // Searching in BST (End)

    public void preOrder(TreeNode root) // Pre-Order Traversal
    {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode root) // In-Order Traversal
    {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void postOrder(TreeNode root) // Post-Order Traversal
    {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void InsertIntoTree(int dataToBeInserted) {
        root = insert(root, dataToBeInserted);
    }

    public TreeNode searchTree(int dataToBeSearched) {
        return search(root, dataToBeSearched);
    }

    public void preOrderTraversal() {
        preOrder(root);
    }

    public void inOrderTraversal() {
        inOrder(root);
    }

    public void postOrderTraversal() {
        postOrder(root);
    }
}