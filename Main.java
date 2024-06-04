// Driver Code
public class Main {
    public static void main(String[] args) {

        Binarysearch bst = new Binarysearch();

        bst.add(50);
        bst.add(30);
        bst.add(20);
        bst.add(40);
        bst.add(70);
        bst.add(60);
        bst.add(80);

        System.out.print("Pre-order Traversal: ");
        bst.printPreorder();
        System.out.println();

        System.out.print("In-order Traversal: ");
        bst.printInorder();
        System.out.println();

        System.out.print("Post-order Traversal: ");
        bst.printPostorder();
        System.out.println();

        System.out.println("Search for 60: " + bst.search(60));
        System.out.println("Search for 90: " + bst.search(90));

        bst.remove(20);
        System.out.println("After removing 20:");
        System.out.print("In-order Traversal: ");
        bst.printInorder();
        System.out.println();
    }
}