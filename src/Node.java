/**
 *
 *
 *
 *
 * @author Steven Sheets    - smsheets@iastate.edu
 * @author Noah Frederiksen - nfred99@iastate.edu
 */
public class Node<T> extends Interval{

    Interval i;
    int max, priority;
    Node left, right, parent;

    /**
     *  Empty treap node constructor
     */
    public Node() {
        new Node(null, 0 , 0 );

    }

    /**
     *  Non-empty treap node constructor
     * @param i
     * @param priority
     * @param max
     */
    public Node(Interval i, int priority, int max) {
        this.i = i;
        this.priority = priority; //not sure how priority is generated
        this.max = max;
        this.left = this.right =  this. parent = null;
    }

    /**
     * Return parent of node
     * @return parent
     */
    public Node getParent() {
        return parent;
    }


    /**
     * return left child of node
     * @return left child
     */
    public Node getLeft(){
        return left;
    }

    /**
     * Return right child of treap node
     * @return right child
     */
    public Node getRight() {
        return right;
    }

    /**
     * Returns interval of treap node
     * @return interval
     */
    public Interval getInterval() {
        return i;
    }

    /**
     * Returns the max right endpoint of this node and all descendent nodes
     * @return
     */
    public int getIMax() {
        return max;
    }

    /**
     * Returns the priority value of this node
     * @return priority
     */
    public int getPriority() {
        return priority;
    }
}
