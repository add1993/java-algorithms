import java.util.*;
import java.lang.*;
import java.io.*;

class LinkedList {
    class Node {
        int val;
        Node next;
		Node(int d) {val = d; next = null; } 
    }
	
    // Insert a node in linked list
    public Node insert(Node root, int val) {
        Node temp = new Node(val);
        if(root == null) {
             root = temp;
        } else {
            Node trav = root;
            while(trav.next != null) {
                trav = trav.next;
            }
            trav.next = temp;
        }
	   return root;
    }    

    // Traverse a linklist given with its root
    public void traverse(Node root){
        if(root == null) {
            System.out.println("Empty Linkedlist");
            return;
        }
        Node tmp = root;
        while(tmp != null) {
            System.out.print(tmp.val + " -> ");
            tmp = tmp.next;
        }
        System.out.println("null");
    }

    // Sort a linklist given with its root.
    public Node sort(Node root) {
        if (root.next == null) return root;
        
        Node start = root;
        Node prev_start = null;
        while (start != null) {
            Node curr = start.next;
            Node prevCurr = start;
            Node min = start;
            Node prev_min = prev_start;
            
            while(curr != null) {
                if(curr.val < min.val){
                    min = curr;
                    prev_min = prevCurr;
                }
                prevCurr = curr;
                curr = curr.next;
            }
            
            if (start == min) {
                prev_start = start;
                start = start.next;
                continue;
            } else {
                if (start.next == min) {
                    Node tmp = start.next;
                    start.next = min.next;
                    min.next = start;
                    if (prev_start != null) {
                        prev_start.next = min;
                    } else {
                        root = min;
                    }
                    prev_start = min;
                    start = min.next;
                    continue;
                } else {
                    Node tmp = start.next;
                    start.next = min.next;
                    min.next = tmp;
                    prev_min.next = start;
                    if (prev_start != null) {
                        prev_start.next = min;
                    } else {
                        root = min;
                    }
                    prev_start = min;
                    start = min.next;
                    continue;
                }
                
            }
        }
        return root;
    }

    public static void main(String[] args) {
		LinkedList list = new LinkedList(); 
        Node head = null;
        head = list.insert(head, 10);
        head = list.insert(head, 1);
        head = list.insert(head, 12);
        head = list.insert(head, 11);
        head = list.insert(head, 10);
        head = list.insert(head, 9);
        head = list.insert(head, 8);
        head = list.insert(head, 7);
        head = list.insert(head, 6);
        head = list.insert(head, 14);
        head = list.insert(head, 2);
        head = list.insert(head, 3);
        head = list.insert(head, 4);
        head = list.insert(head, 5);
	    head = list.insert(head, 13);

        // Traverse the linked list
        System.out.println("LinkList before sorting is:");
        list.traverse(head);
        head = list.sort(head);
        System.out.println("LinkList after sorting is:");
        list.traverse(head);
    }
}
