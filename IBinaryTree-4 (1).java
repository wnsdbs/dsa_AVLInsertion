public interface IBinaryTree<T> {
	public int height();  // return the tree height
	public void insert(T value);  // insert a new value into the tree
	public void insert(T[] value);  // insert new values into the tree from an array
	public boolean remove(int key);  // remove node holding the specified key from the tree, returns true if found, false otherwise
	public AVLNode search(int key);  // find the key in the tree, returning its tree node, or null if it is not found
	public void print();  // print the tree vertically, one Student per line, in breadth-first mode
}
