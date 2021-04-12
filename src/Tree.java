* @author Raeef Bechara
 * @Version 2021-02-18
 *
 */
public class Tree <T extends Comparable<T>> {
    private Node<T> root;
    private int size;


    //The node class is inside the BST-class.
    private static class Node<T> {
        private Node<T> left;
        private Node<T> right;
        private T value;

        //The constructor to a node.
        public Node(T value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    /**
     * Adds a node with a certain value to the tree.
     * Duplicates will not be assigned to the tree.
     * @return true if the value was inserted in the tree, false if
     * otherwise.
     */
    public boolean insert(T insertNodeValue) {
        Node<T> insertNode = new Node<>(insertNodeValue);
        if(root == null) {
            root = insertNode;
            size++;
            return true;
        }
        Node<T> currentNode = root;
        while(true) {
            if(currentNode.value.compareTo(insertNodeValue) < 0) {
                if(currentNode.right == null) {
                    currentNode.right = insertNode;
                    size++;
                    return true;
                }
                currentNode = currentNode.right;
            }
            else if(currentNode.value.compareTo(insertNodeValue) > 0) {
                if(currentNode.left == null) {
                    currentNode.left = insertNode;
                    size++;
                    return true;
                }
                currentNode = currentNode.left;
            }
            if(currentNode.value.compareTo(insertNodeValue) == 0) {
                return false;
            }
        }
    }

    /**
     * Searches for the wanted value in the tree.
     * @return true if it exists, false if otherwise.
     */
    public boolean search(T chosenNodeValue) {
        Node<T> currentNode = root;
        if(currentNode == null) {
            return false;
        }
        while(true) {
            if(currentNode.value.compareTo(chosenNodeValue) == 0) {
                return true;
            }
            if(currentNode.value.compareTo(chosenNodeValue) < 0) {
                if(currentNode.right == null) {
                    return false;
                }
                else {
                    currentNode.right = currentNode;
                }
            }
            if(currentNode.value.compareTo(chosenNodeValue) > 0) {
                if(currentNode.left == null) {
                    return false;
                }
                else {
                    currentNode.left = currentNode;
                }
            }
        }
    }
    /**
     * Shows the number of elements in the tree. The number is
     * updated whenever the insert-method successfully inserts
     * an element to the tree.
     * @return number of elements.
     */
    public int size() {
        return size;
    }

    /**
     * Shows the height of the tree. The height is
     * the amount of levels you can traverse through the tree.
     * @return number of tree's height.
     */
    public int height(){
        return height(root);
    }

    private int height(Node<T> nodeHeight) {
        if(nodeHeight == null) {
            return 0;
        }
        int rightHeight = height(nodeHeight.right);
        int leftHeight = height(nodeHeight.left);
        if(rightHeight > leftHeight) {
            return rightHeight + 1;
        }
        else {
            return leftHeight + 1;
        }
    }

    /**
     * Shows the number of leaves the tree has. Leaves can be
     * expressed as the nodes that has null in both their left
     * and right side.
     * @return number of leaves.
     */
    public int leaves(){
        return leaves(root);
    }
    private int leaves(Node<T> root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        else {
            return(leaves(root.left) + leaves(root.right));
        }
    }

    /**
     * Prints out the tree in a String-oriented form.
     * @return string of the tree.
     */
    public String toString(Node<T> stringNode) {
        String emptyString = "";
        if(stringNode == null) {
            return emptyString;
        }
        emptyString = emptyString + stringNode.value;
        emptyString = emptyString + " (" + toString(stringNode.left) + ") (" + toString(stringNode.right) + ")";
        return emptyString;

    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<Integer>();
    }

}
