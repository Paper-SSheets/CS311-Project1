/**
 * Represents the Nodes in the IntervalTreap.
 *
 * @author Steven Sheets    - smsheets@iastate.edu
 * @author Noah Frederiksen - nfred99@iastate.edu
 */
public class Node {

    /** The Interval of this Node. */
    private Interval interv;

    /** The left child of this Node. */
    private Node left;

    /** The right child of this Node. */
    private Node right;

    /** The parent of this Node. */
    private Node parent;

    /** The imax of this Node. */
    private int imax;

    /** The priority of this Node. */
    private int priority;

    /** The height of this Node. */
    private int height;

    /**
     * Constructs a new instance of this Node class with a
     * given Interval i.
     *
     * @param i - The Interval to be used with this Node.
     */
    public Node(Interval i) {
        interv = i;
        left = right = parent = null;
        height = imax = priority = 0; // imax and priority are immediately modified to legitimate values.
    }

    /**
     * Returns the parent of this Node.
     *
     * @return - The parent of this Node
     */
    public Node getParent() {
        return parent;
    }

    /**
     * Returns the left child of this Node.
     *
     * @return - The left child of this Node
     */
    public Node getLeft() {
        return left;
    }

    /**
     * Returns the right child of this Node.
     *
     * @return - The right child of this Node
     */
    public Node getRight() {
        return right;
    }

    /**
     * Returns the Interval interv of this class.
     *
     * @return - The Interval interv of this class
     */
    public Interval getInterv() {
        return interv;
    }

    /**
     * Returns the imax of this Node.
     *
     * @return - The imax of this Node
     */
    public int getIMax() {
        return imax;
    }

    /**
     * Returns the priority of this Node.
     *
     * @return - The priority of this Node
     */
    public int getPriority() {
        return priority;
    }

    /* ******** "NON-REQUIRED" METHODS BELOW ********* */

    /**
     * Sets the parent of this Node.
     *
     * @param parent - The new parent of the this Node
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     * Sets the left child of this Node.
     *
     * @param left - The new left child of this Node
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * Sets the right child of this Node.
     *
     * @param right - The new right child of this Node
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * Sets the Interval interv of this class.
     *
     * @param interv - The new interv of this class
     */
    public void setInterv(Interval interv) {
        this.interv = interv;
    }

    /**
     * Sets the imax of this Node.
     *
     * @param imax - The new imax of this Node
     */
    public void setIMax(int imax) {
        this.imax = imax;
    }

    /**
     * Sets the priority of this Node.
     *
     * @param priority - The new priority of this Node
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Returns the height of this Node.
     *
     * @return - The height of this Node
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the height of this Node.
     *
     * @param height - The new height of this Node
     */
    public void setHeight(int height) {
        this.height = height;
    }
}
