README
1. Use the java compiler to first compile the java file using javac command.
	javac tree.java
	
2. Use java command to run the generated class file.
	java tree
	
This code has been tested on leetcode testcases. It passes all the testcases.

Run log :
    Tree inorder traversal before deletion is:
    4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 10 -> 11 -> 12 -> 12 -> 13 -> 14 -> 15 -> 16 -> 
    Tree level traversal before deletion is:
    10 
    7 12 
    6 9 11 14 
    5 8 10 12 13 15 
    4 16 
    Tree inorder traversal after deletion 16 is:
    4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 10 -> 11 -> 12 -> 12 -> 13 -> 14 -> 15 -> 
    Tree level traversal after deletion is:
    10 
    7 12 
    6 9 11 14 
    5 8 10 12 13 15 
    4 
    Tree inorder traversal after deletion 10 is:
    4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 11 -> 12 -> 12 -> 13 -> 14 -> 15 -> 
    Tree level traversal after deletion is:
    11 
    7 12 
    6 9 12 14 
    5 8 10 13 15 
    4 

