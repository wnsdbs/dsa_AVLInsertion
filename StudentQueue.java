public class StudentQueue {
    // Node definition for the Student queue
    public class Node{
    	AVLNode data;  // holds the student
        Node next;     // acts as the pointer to the next member of the queue
        Node prev;     // acts as the pointer to the next member of the queue
        public Node(AVLNode data) { // constructor for the new node
            this.data = data;       // having this as the only line ensures the next and prev values will be null by default
        }
    }  
    
    // initially head and tail pointers point to null
    private Node head = null;
    private Node tail = null;
    private int length = 0;
    
    // return the length of the queue
    public int length() {
    	return length;
    }
    
    // returns the first integer of the queue and removes it from the list, or throws an error if the list is empty
    public AVLNode next() {
        if (length == 0) {
            return null;
        }
        
        Node temp = head;
        
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        
        length--;
        
        return temp.data;
    }

    // add a new BinaryTreeNode to the end of the queue
    public void add(AVLNode k) {
        Node newNode = new Node(k);
        length++;

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
    
    // print the nodes of the queue from head to tail
    public void print() {
    	Node currentNode = head;
    	for (int i = 0; i < length; i++) {
    		System.out.print(currentNode.data.data.studentId + "  ");
    		currentNode = currentNode.next;
    	}
    }
}
