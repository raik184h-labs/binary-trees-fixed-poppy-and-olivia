package edu.unl.raikes.BinarySearchTreeLab;

/**
 * This class controls the functionality of the nodes.
 */
class BinarySearchNode {
    protected BinarySearchNode parent;
    protected BinarySearchNode leftChild;
    protected BinarySearchNode rightChild;
    protected Person person;

    /**
     * Constructor for BinarySearchNode.
     * @param person - takes the person node
     */
    BinarySearchNode(Person person) {
        this.person = person;
    }

    /**
     * Inserts the data into the null node in the correct order.
     * @param data - the data we want to insert
     * @return - true if inserted and false if not
     */
    boolean insert(Person data) {
        // if the data already exists, don't insert
        if (data == this.person) {
            return false;
        }
        // else if person is less than the current node recurse on the left child
        else if (Integer.compare(data.key, this.person.key) < 0) {
            // if leftchild is null, insert the data here
            if (this.leftChild == null) {
                this.setLeftChild(new BinarySearchNode(data));
                return true;
            } // else recurse until you find a null node
            else {
                return this.leftChild.insert(data);
            }
        }
        // else if the person is greater than the current node, recurse on the right child
        else if (Integer.compare(data.key, this.person.key) > 0) {
            // if the right child is null, add data here
            if (this.rightChild == null) {
                this.setRightChild(new BinarySearchNode(data));
                return true;
            } // else, recurse on the right child
            else {
                return this.rightChild.insert(data);
            }
        }
        return false;
    }

    /**
     * Searches for the key.
     * @param key - key to search for
     * @return - the node at the key
     */
    BinarySearchNode search(int key) {
        // if left child is not null and the key is less than, recurse on left child
        if (this.leftChild != null && Integer.compare(key, this.person.key) < 0) {
            return this.leftChild.search(key);
        }
        // if right child is not null and the key is greater than, recurse on right child
        else if (this.rightChild != null && Integer.compare(key, this.person.key) > 0) {
            return this.rightChild.search(key);
        }
        // if the key is equal to the current key, return it
        else if (this.person.key == key) {
            return this;
        }
        // otherwise return null
        else {
            return null;
        }
    }

    /**
	 * This function deletes the given node at the given key.
	 * @param key - the key to delete
	 * @return - 
	 */
    Person delete(int key) {
        // TODO: ADD COMMENT
        BinarySearchNode node = search(key);
        if (node == null)
            return null;
        Person deleted = node.person;

        // TODO: ADD COMMENT
        if (node.leftChild == null && node.rightChild == null) {
            if (node.parent.leftChild == node)
                node.parent.setLeftChild(null);
            else if (node.parent.rightChild == node)
                node.parent.setRightChild(null);
        }
        // TODO: ADD COMMENT
        else if (node.leftChild != null && node.rightChild != null) {
            BinarySearchNode min = node.rightChild.getNodeWithMinValue();
            node.person = min.person;
            int minKey = min.person.key;
            min.delete(minKey);
        }
        // TODO: ADD COMMENT
        else if (node.parent.leftChild == node) {
            BinarySearchNode newLeftChild = (node.leftChild != null) ? node.leftChild : node.rightChild;
            node.parent.setLeftChild(newLeftChild);
        }
        // TODO: ADD COMMENT
        else if (node.parent.rightChild == node) {
            BinarySearchNode newRightChild = (node.leftChild != null) ? node.leftChild : node.rightChild;
            node.parent.setRightChild(newRightChild);
        }

        return deleted;
    }

    // TODO: ADD JAVADOC COMMENT
    BinarySearchNode getNodeWithMinValue() {
        if (leftChild == null)
            return this;
        else
            return leftChild.getNodeWithMinValue();
    }

    // TODO: ADD JAVADOC COMMENT
    void setLeftChild(BinarySearchNode child) {
        this.leftChild = child;
        if (child != null)
            child.parent = this;
    }

    // TODO: ADD JAVADOC COMMENT
    void setRightChild(BinarySearchNode child) {
        this.rightChild = child;
        if (child != null)
            child.parent = this;
    }

    // TODO: ADD JAVADOC COMMENT (WHAT KIND OF SEARCH SHOULD THIS BE???)
    public String toString() {
        StringBuilder toReturn = new StringBuilder();
        
        // TODO: ADD COMMENT
        buildInOrderString(toReturn);

        return toReturn.toString();
    }

    private void buildInOrderString(StringBuilder sb) {
        if (this.leftChild != null) {
            this.leftChild.buildInOrderString(sb);
        }

        sb.append(this.person.toString()).append("\n");

        if (this.rightChild != null) {
            this.rightChild.buildInOrderString(sb);
        }
    }

}