README
1. Use the java compiler to first compile the java file using javac command.
	javac LinkedList.java
	
2. Use java command to run the generated class file.
	java LinkedList
	
Run log :
{csgrads1:~/public_html} ls
LinkedList.java  ProjectL
{csgrads1:~/public_html} javac LinkedList.java
{csgrads1:~/public_html} ls
LinkedList.class  LinkedList.java  LinkedList$Node.class
{csgrads1:~/public_html} java LinkedList
LinkList before sorting is:
10 -> 1 -> 12 -> 11 -> 10 -> 9 -> 8 -> 7 -> 6 -> 14 -> 2 -> 3 -> 4 -> 5 -> 13 -> null
LinkList after sorting is:
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 10 -> 11 -> 12 -> 13 -> 14 -> null