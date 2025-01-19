package com.mycompany.bst;

public class BST {

    static Node root;

    public BST() {
        root = null;
    }

    static class Node {

        public Node right;
        public Node left;
        public Integer val;

        public Node(Integer val) {
            this.val = val;
        }
    }

    public static void insert(int a) {
        root = insertRecursive(root, a);
    }

    static Node insertRecursive(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.val) {
            node.left = insertRecursive(node.left, value);
        } else if (value > node.val) {
            node.right = insertRecursive(node.right, value);
        }
        return node;
    }

    static boolean search(int value) {
        return searchRecursive(root, value);
    }

    static boolean searchRecursive(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (node.val == value) {
            return true;
        }
        return value < node.val
                ? searchRecursive(node.left, value)
                : searchRecursive(node.right, value);
    }

    static void delete(int key) {
        root = deleteRecursive(root, key);
    }

    static Node deleteRecursive(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.val) {
            node.left = deleteRecursive(node.left, key);
        } else if (key > node.val) {
            node.right = deleteRecursive(node.right, key);
        } else {
            // No child
            if (node.left == null && node.right == null) {
                return null;
            }
            // One child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            // Two children
            node.val = minValue(node.right);
            node.right = deleteRecursive(node.right, node.val);
        }
        return node;
    }

    static int minValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    static int countLeaf(Node node) {
        if (node == null) {
            return 0;
        }
        if (isLeaf(node)) {
            return 1;
        }
        return countLeaf(node.left) + countLeaf(node.right);
    }

    static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }

    // Print Leaves
    static void printLeaf(Node node) {
        if (node == null) {
            return;
        }
        if (isLeaf(node)) {
            System.out.print(node.val + " ");
        }
        printLeaf(node.left);
        printLeaf(node.right);
    }

    // Print Tree
    static void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }

    public static void main(String[] args) {
        BST tree = new BST();

        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(15);

        System.out.println("In-Order Traversal:");
        tree.printInOrder(root);

        System.out.println("\nSearch for 15: " + tree.search(15));
        System.out.println("Search for 25: " + tree.search(25));

        System.out.println("\nDelete 10:");
        tree.delete(10);
        tree.printInOrder(root);
    }

}
