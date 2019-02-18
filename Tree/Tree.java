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
	
	public Node deleteNode(Node root, int val) {
        if (root == null) {
			return root;
		}
		
		if (root.val == val) {
			Node successor = null, predecessor = null, parent = null;
			if (root.left == null && root.right == null) {
				root = null;
			} else if (root.right != null) {
				successor = root.right;
				while (successor.left != null) {
					parent = successor;
					successor = successor.left;
				}
				Node left, right;
				if (root.right == successor) {
					right = successor.right;
				} else {
					right = root.right;
				}
				
				if (parent != null) {
					parent.left =  deleteNode(parent.left, successor.val);;
				}
				
				left = root.left;
				root = successor;
				root.left = left;
				root.right = right;
				
			} else {
				predecessor = root.left;
				while (predecessor.right != null) {
					parent = predecessor;
					predecessor = predecessor.right;
				}
				Node left, right;
				if (predecessor == root.left) {
					left = predecessor.left;
				} else {
					left = root.left;
				}
				
				if (parent != null) {
					parent.right = deleteNode(parent.right, predecessor.val);
				}
				
				right = root.right;
				root = predecessor;
				root.left = left;
				root.right = right;
			}
		} else if (val > root.val) {
            root.right = deleteNode(root.right, val);
        } else if (val <= root.val) {
			root.left = deleteNode(root.left, val);
		}
		return root;
	}
    // Traverse a tree given with its root
    public void inorder(Node root){
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " -> ");
        inorder(root.right);
    }
	
	public void levelTraverse(Node root){
        Queue<Node> Q = new LinkedList<Node>();
		Q.add(root);
		
		while (Q.isEmpty() == false) {
			int N = Q.size();
			
			for (int i = 0; i < N; i++) {
				Node node = Q.peek();
				Q.remove();
				System.out.print(node.val + " ");
				if (node.left != null) {
					Q.add(node.left);
				}
				
				if (node.right != null) {
					Q.add(node.right);
				}
			}
			System.out.println();
		}
    }

    public static void main(String[] args) {
		Tree tree = new Tree(); 
        Node root = null;
        root = tree.insert(root, 10);
        root = tree.insert(root, 7);
        root = tree.insert(root, 12);
        root = tree.insert(root, 11);
        root = tree.insert(root, 14);
        root = tree.insert(root, 13);
        root = tree.insert(root, 15);
        root = tree.insert(root, 9);
        root = tree.insert(root, 8);
        root = tree.insert(root, 10);
        root = tree.insert(root, 6);
        root = tree.insert(root, 5);
		root = tree.insert(root, 16);
		root = tree.insert(root, 4);
		root = tree.insert(root, 12);

        // Traverse the tree
        System.out.println("Tree inorder traversal before deletion is:");
		tree.inorder(root);
		System.out.println("\nTree level traversal before deletion is:");
        tree.levelTraverse(root);
		
		root = tree.deleteNode(root, 16);
		System.out.println("Tree inorder traversal after deletion "+16+" is:");
        tree.inorder(root);
		System.out.println("\nTree level traversal after deletion is:");
        tree.levelTraverse(root);
		
		root = tree.deleteNode(root, 10);
		System.out.println("Tree inorder traversal after deletion "+10+" is:");
        tree.inorder(root);
		System.out.println("\nTree level traversal after deletion is:");
        tree.levelTraverse(root);
    }
}