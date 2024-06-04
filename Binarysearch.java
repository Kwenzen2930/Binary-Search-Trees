class Node {
    int data;
    Node left;
    Node right;

    // Constructor to create a new node with the given value
    Node(int k) {
        this.data = k;
        this.left = this.right = null;
    }
}

class Binarysearch {
    Node root;

    // Method to start the inorder traversal from the root
    public void printInorder() {
        printInorder(root);
    }

    // Inorder traversal: left, root, right
    private void printInorder(Node node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    // Method to start the preorder traversal from the root
    public void printPreorder() {
        printPreorder(root);
    }

    // Preorder traversal: root, left, right
    private void printPreorder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    // Method to start the postorder traversal from the root
    public void printPostorder() {
        printPostorder(root);
    }

    // Postorder traversal: left, right, root
    private void printPostorder(Node node) {
        if (node == null)
            return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    // Method to add a new value to the tree
    public void add(int value) {
        root = add(root, value);
    }

    // Recursive method to add a value to the tree
    private Node add(Node node, int value) {
        // If the tree/subtree is empty, create a new node
        if (node == null) {
            return new Node(value);
        }

        // Recursively add to the left or right subtree
        if (value < node.data) {
            node.left = add(node.left, value);
        } else if (value > node.data) {
            node.right = add(node.right, value);
        }

        return node;
    }

    // Method to remove a value from the tree
    public void remove(int value) {
        root = remove(root, value);
    }

    // Recursive method to remove a value from the tree
    private Node remove(Node node, int value) {
        // Base case: if the tree is empty
        if (node == null) {
            return node;
        }

        // Recursively find the node to remove
        if (value < node.data) {
            node.left = remove(node.left, value);
        } else if (value > node.data) {
            node.right = remove(node.right, value);
        } else {
            // Node to be removed found

            // Case 1: Node with only one child or no child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Case 2: Node with two children
            // Get the inorder successor (smallest in the right subtree)
            node.data = findMinValue(node.right);

            // Delete the inorder successor
            node.right = remove(node.right, node.data);
        }

        return node;
    }

    // Method to search for a value in the tree
    public boolean search(int value) {
        return search(root, value);
    }

    // Recursive method to search for a value
    private boolean search(Node node, int value) {
        // Base case: if the tree is empty
        if (node == null) {
            return false;
        }

        // Recursively search in the left or right subtree
        if (value < node.data) {
            return search(node.left, value);
        } else if (value > node.data) {
            return search(node.right, value);
        } else {
            // Value found
            return true;
        }
    }

    // Method to find the minimum value in a subtree
    private int findMinValue(Node node) {
        int minValue = node.data;

        // Loop to find the leftmost leaf
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }

        return minValue;
    }
}
