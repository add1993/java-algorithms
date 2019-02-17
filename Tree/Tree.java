import java.util.*;
import java.lang.*;
import java.io.*;

class Tree {
    class Node {
        int val;
        Node left, right;
		Node(int d) {val = d; left = null; right = null;} 
    }
	
    // Insert a node in tree
    public Node insert(Node root, int val) {
        Node temp = new Node(val);
        if(root == null) {
             root = temp;
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        } else if (val <= root.val) {
			root.left = insert(root.left, val);
		}
	   return root;
    }    
	
	public Node delete(Node root, int val) {
		if (root.val == val) {
			Node successor = null, predecessor = null;
			
			
		}
		return null;
	}
    // Traverse a tree given with its root
    public void traverse(Node root){
        if(root == null) {
            return;
        }
        traverse(root.left);
        System.out.print(root.val + " -> ");
        traverse(root.right);
    }
	
	public void levelTraverse(Node root){
        //Queue<Node> Q = new Queue
    }

    public static void main(String[] args) {
		Tree tree = new Tree(); 
        Node root = null;
        root = tree.insert(root, 10);
        root = tree.insert(root, 1);
        root = tree.insert(root, 12);
        root = tree.insert(root, 11);
        root = tree.insert(root, 10);
        root = tree.insert(root, 9);
        root = tree.insert(root, 8);
        root = tree.insert(root, 7);
        root = tree.insert(root, 6);
        root = tree.insert(root, 14);
        root = tree.insert(root, 2);
        root = tree.insert(root, 3);
        root = tree.insert(root, 4);
        root = tree.insert(root, 5);
	    root = tree.insert(root, 13);

        // Traverse the tree
        System.out.println("Tree before sorting is:");
        tree.traverse(root);
    }
}
