class Node {

    int data;
    Node left;
    Node right;

    Node(int k) {
        this.data = k;
        this.left = this.right = null;
    }
}

class Binarysearch {
    Node root;

    // Inorder
    public void printInorder() {
        printInorder(root);
    }

    private void printInorder(Node node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    // Preorder Traversal
    public void printPreorder() {
        printPreorder(root);
    }

    private void printPreorder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    // Postorder Traversal
    public void printPostorder() {
        printPostorder(root);
    }

    private void printPostorder(Node node) {
        if (node == null)
            return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    public void add(int value) {
        root = add(root, value);
    }

    private Node add(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.data) {
            node.left = add(node.left, value);
        } else if (value > node.data) {
            node.right = add(node.right, value);
        }

        return node;
    }

    public void remove(int value) {
        root = remove(root, value);
    }

    private Node remove(Node node, int value) {
        if (node == null) {
            return node;
        }

        if (value < node.data) {
            node.left = remove(node.left, value);
        } else if (value > node.data) {
            node.right = remove(node.right, value);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            node.data = findMinValue(node.right);
            node.right = remove(node.right, node.data);
        }

        return node;
    }

    public boolean search(int value) {
        return search(root, value);
    }

    private boolean search(Node node, int value) {
        if (node == null) {
            return false;
        }

        if (value < node.data) {
            return search(node.left, value);
        } else if (value > node.data) {
            return search(node.right, value);
        } else {
            return true;
        }
    }

    private int findMinValue(Node node) {
        int minValue = node.data;

        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }

        return minValue;
    }
}