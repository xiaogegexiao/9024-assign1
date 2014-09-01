                                              Assignment One


In this assignment, you extend the doubly linked list class Dlist given in the textbook Chapter
3.3.3. You can download the source code from the textbook website (http://ww0.java4.datastructures.net/). 
The subclass is named MyDlist.. You need to implement the following constructors and methods of MyDlist:

1. public MyDlist(). This constructor creates an empty doubly linked list. 

2. public MyDlist(String f). This constructor creates a doubly linked list by reading all strings from a 
text file named f. Assume that adjacent strings in the file f are separated by one or more white space 
characters. If f is “stdin”, MyDlist(“stdin”) creates a doubly linked list by reading all strings from 
the standard input. Assume that each input line is a string and an empty line denotes end of input.

3. public void printList(). This instance method prints all elements of a list on the standard output, one 
element per line.

4. public static MyDlist cloneList(MyDlist u). This class method creates an identical copy of a doubly 
linked list u and returns a reference to the resulting doubly linked list.

5. public static MyDlist concatenateList(MyDlist u, MyDlist v). This class method concatenates two 
doubly linked lists u and v into a single doubly linked list and returns a reference to the resulting 
doubly linked list. In the resulting doubly linked list, the linked list u precedes the linked list v.

6. public void removeNode(String e). This instance method removes all the nodes whose elements are 
equal to e. If such a node does not exist, this method will print “ no node contains e!” on the standard 
output.
