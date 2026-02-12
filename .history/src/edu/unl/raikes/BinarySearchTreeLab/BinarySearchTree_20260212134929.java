package edu.unl.raikes.BinarySearchTreeLab;

/**
 * Class that controls the functionality of the BinarySearchTree.
 */
public class BinarySearchTree {
    boolean verbose = true;
    private BinarySearchNode root = null;
    private int size = 0;

    /**
     * Inserts the data at the node.
     * @param data - the data to insert
     */
    public void insert(Person data) {
        boolean inserted = false;
        // if the root is null, insert the data here
        if (this.root == null) {
            this.root = new BinarySearchNode(data);
            inserted = true;
        } // else, recurse
        else {
            inserted = this.root.insert(data);
        } // if it is inserted, increase the size
        if (inserted) {
            this.size++;
        }
    }

    /**
     * This is the search function that searches for the given key.
     * @param key - key to search for
     * @return - the key
     */
    public Person search(int key) {
        // if the root is null, the whole thing is null so return null
        if (this.root == null) {
            return null;
        }
        // recurse 
        BinarySearchNode found = this.root.search(key);
        // if the key is found, return person
        if (found != null) {
            return found.person;
        } else {
            return null;
        }

    }

    /**
	 * This function deletes the 
	 * @param key
	 * @return
	 */
    public Person delete(int key) {
        Person deleted = null;

        // TODO: ADD COMMENT
        if (root == null) {
            return null;
        } // TODO: ADD COMMENT
        else {
            // TODO: ADD COMMENT
            if (root.person.key == key) {
                // add fake root in case the element to be removed is the root.
                // (simplifies pointer logic)
                BinarySearchNode auxRoot = new BinarySearchNode(null);
                auxRoot.setLeftChild(root);
                // TODO: ADD COMMENT
                deleted = root.delete(key);
                // retrieve the root from the fake root (in case it changed)
                root = auxRoot.leftChild;
                // TODO: ADD COMMENT
                if (root != null)
                    root.parent = null;
            } // TODO: ADD COMMENT
            else {
                deleted = root.delete(key);
            } // TODO: ADD COMMENT
            if (deleted != null)
                size--;
            return deleted;
        }
    }

    // TODO: ADD JAVADOC COMMENT
    public String toString() {
        String toReturn = "Binary Search Tree of Size: " + this.size + "\n";
        // TODO: ADD COMMENT
        if (this.root != null) {
            toReturn += this.root.toString();
        }
        return toReturn;
    }

}
