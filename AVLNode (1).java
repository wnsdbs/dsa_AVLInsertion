public class AVLNode {
	Student data; // holds the student information
	AVLNode left; // acts as the pointer to the left child of this node
	AVLNode right; // acts as the pointer to the right child of this node
	AVLNode parent; // pointer to the parent of this node
	int height; // height of this node's subtree
	
	public AVLNode(Student data) { // constructor for the new node
		this.data = data; // having this as the only line ensures the left and right values will be null by default
	}
}