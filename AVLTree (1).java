
public class AVLTree implements IBinaryTree<Student> {
    private AVLNode root = null;
    
    private enum Direction {
        Left,
        Right
    }
    
    // remove node holding the specified key from the tree, returns true if found, false otherwise
    public boolean remove(int key) {
        return false;
    }
    
    // return the tree height
    public int height() {
        if (root == null) {
            return -1;
        } else {
            return root.height;
        }
    }
    
    // insert new values into the tree from an array
    public void insert(Student[] values) {
        for (int i = 0; i < values.length; i++) {
            insert(values[i]);
        }
    }
    
    // insert a new value into the tree
    public void insert(Student value) {
        AVLNode node = new AVLNode(value);

        if (root == null) {
            root = node;
            node.height = 0;
        } else {
            attachToNode(root, node);
            while (node != null) {
            updateHeight(node);
            int balanceFactor = getBalanceFactor(node);
            if (balanceFactor > 1 || balanceFactor < -1) {
                rebalanceTree(node, findRebalance(node));
            }
            node = node.parent;
            }
        
        /* Check to see if the new node threw the tree off balance.  If
         * that happened, we want to fix the unbalanced ancestor closest to
         * the new node.  That will fix the tree. */
        }
    }

    // modular method
    private Direction[] findRebalance(AVLNode node) {
        int balanceFactor = getBalanceFactor(node);
        int leftBalanceFactor = 0;
        int rightBalanceFactor = 0;
        if (node.left != null) {
            leftBalanceFactor = getBalanceFactor(node.left);
        }
        if (node.right != null) {
            rightBalanceFactor = getBalanceFactor(node.right);
        }
        
        if (balanceFactor > 1) {
            if (leftBalanceFactor >= 0) {
                // Left Left case
                Direction[] directions = new Direction[2];
                directions[0] = Direction.Left;
                directions[1] = Direction.Left;
                return directions; 
            } else {
                // Left Right case
                Direction[] directions = new Direction[2];
                directions[0] = Direction.Left;
                directions[1] = Direction.Right;
                return directions; 
            }
        } else if (balanceFactor < -1) {
            if (rightBalanceFactor >= 0) {
                // Right Left case
                Direction[] directions = new Direction[2];
                directions[0] = Direction.Right;
                directions[1] = Direction.Left;
                return directions; 
            } else {
                // Right Right case
                Direction[] directions = new Direction[2];
                directions[0] = Direction.Right;
                directions[1] = Direction.Right;
                return directions; 
            }
        }
        return null;
    }

    // modular method
    private void updateHeight(AVLNode node) {
        // calculate the height of the left subtree
        int leftHeight = -1;
        if (node.left != null) {
            leftHeight = node.left.height;
        }
        // calculates the height of the right subtree
        int rightHeight = -1;
        if (node.right != null) {
            rightHeight = node.right.height;
        }
        // update the height of the current node
        node.height = Math.max(leftHeight, rightHeight) + 1;
    }

    private void rebalanceTree(AVLNode node, Direction[] rebalanceDirections) {
        // rotations based on the rebalance directions
        if (rebalanceDirections[0] == Direction.Left && rebalanceDirections[1] == Direction.Left) {
            // Left Left case
            rotateClockwise(node);
        } else if (rebalanceDirections[0] == Direction.Left && rebalanceDirections[1] == Direction.Right) {
            // Left Right case
            rotateCounterClockwise(node.left);
            rotateClockwise(node);
        } else if (rebalanceDirections[0] == Direction.Right && rebalanceDirections[1] == Direction.Left) {
            // Right Left case
            rotateClockwise(node.right);
            rotateCounterClockwise(node);
        } else if (rebalanceDirections[0] == Direction.Right && rebalanceDirections[1] == Direction.Right) {
            // Right Right case
            rotateCounterClockwise(node);
        }
    }
    
    private void rotateClockwise(AVLNode node) {
       // store the left child as pivot
       AVLNode pivot = node.left;
       // update left child of node with right child of pivot
       node.left = pivot.right;
       if (pivot.right != null) {
           pivot.right.parent = node;
       }
       // update parent of pivot
       pivot.parent = node.parent;
       // update parent of node's parent to pivot if node was root
       if (node.parent == null) {
           root = pivot;
       } else if (node == node.parent.right) {
           node.parent.right = pivot;
       } else {
           node.parent.left = pivot;
       }
       // update right child of pivot to node
       pivot.right = node;
       node.parent = pivot;
       // update heights after rotation
       updateHeight(node);
       updateHeight(pivot);
    }
    
    private void rotateCounterClockwise(AVLNode node) {
        // store the right child as pivot
         AVLNode pivot = node.right;
         // update right child of node with left child of pivot
         node.right = pivot.left;
         if (pivot.left != null) {
             pivot.left.parent = node;
         }
         // update parent of pivot
         pivot.parent = node.parent;
         // update parent of node's parent to pivot if node was root
         if (node.parent == null) {
             root = pivot;
         } else if (node == node.parent.left) {
             node.parent.left = pivot;
         } else {
             node.parent.right = pivot;
         } 
         // update left child of pivot to node
         pivot.left = node;
         node.parent = pivot;
         // update heights after rotation
         updateHeight(node);
         updateHeight(pivot);
    }
    
    private void fixLeftLeft(AVLNode node) {
        // fixes Left Left imbalance
        rotateClockwise(node);
    }
    
    private void fixLeftRight(AVLNode node) {
        // fixes Left Right imbalance
        rotateCounterClockwise(node.left);
        rotateClockwise(node);
    }
    
    private void fixRightLeft(AVLNode node) {
        // fixes Right Left imbalance
        rotateClockwise(node.right);
        rotateCounterClockwise(node);
    }
    
    private void fixRightRight(AVLNode node) {
        // fixes Right Right imbalance
        rotateCounterClockwise(node);
    }
    
    private int getBalanceFactor(AVLNode node) {
        // calculates the balance factor of the node
        int leftHeight = -1;
        int rightHeight = -1;
    
        if (node.left != null) {
            leftHeight = node.left.height;
        }
        if (node.right != null) {
            rightHeight = node.right.height;
        }
        return leftHeight - rightHeight;
    }
    
    // a method that hangs the new node off of the proper side of the current node
    // and recurses if the desired spot is not null
    private void attachToNode(AVLNode parent, AVLNode node) {
        if (node.data.studentId >= parent.data.studentId) {
            if (parent.right == null) {
                parent.right = node;
                node.parent = parent;
                node.height = 0;
                
                /* if we add a leaf to a node that has no other leaf, then we are increasing
                 * that node's height.  Once we do that, we must check to see if any other
                 * ancestors have had their heights change.  If we added the leaf to a node
                 * that already had another leaf, then we didn't change the node's height,
                 * so its, and all it's ancestors' heights will be unaffected. */
                if (parent.left == null) {
                    resetAncestorHeights(parent);
                }
            } else {
                attachToNode(parent.right, node);
            }
        } else {
            if (parent.left == null) {
                parent.left = node;
                node.parent = parent;
                node.height = 0;
                
                /* if we add a leaf to a node that has no other leaf, then we are increasing
                 * that node's height.  Once we do that, we must check to see if any other
                 * ancestors have had their heights change.  If we added the leaf to a node
                 * that already had another leaf, then we didn't change the node's height,
                 * so its, and all it's ancestors' heights will be unaffected. */
                if (parent.right == null) {
                    resetAncestorHeights(parent);
                }
            } else {
                attachToNode(parent.left, node);
            }
        }
    }

    // reset the height of the specified node, and all its ancestors
    private void resetAncestorHeights(AVLNode node) {
        while (node != null) {
            int leftHeight = (node.left != null) ? node.left.height : 0;
            int rightHeight = (node.right != null) ? node.right.height : 0;
            int newHeight = Math.max(leftHeight, rightHeight) + 1;
            if (node.height == newHeight) {
                // if the height remains unchanged
                break;
            }
            node.height = newHeight;
            // move to the parent node
            node = node.parent; 
        }
    }

    // find the key in the tree, returning its tree node, or null if it is not found
    public AVLNode search(int key) {
        AVLNode currentNode = root;
        while (currentNode != null) {
            if (currentNode.data.studentId == key) {
                return currentNode;
            } else {
                if (key < currentNode.data.studentId) {
                    if (currentNode.left == null) {
                        return null;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        return null;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }
        
        return null;
    }
    
    // print the tree vertically, one Student per line, in breadth-first mode
    public void print() {
        if (root == null) System.out.println("There are no nodes in the tree.");
        
        // build a queue of Students to enable breadth-first printing
        StudentQueue queue = new StudentQueue();
        AVLNode currentNode = root;
        while (currentNode != null) {
            // if there is a left node, add it to the queue
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            // if there is a right node, add it to the queue
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
            
            // print the node
            Student student = currentNode.data;
            student.print();
            
            // end the loop when we're out of students
            if (queue.length() == 0) {
                currentNode = null;
            } else {
                currentNode = queue.next();
            }
        }
    }
}