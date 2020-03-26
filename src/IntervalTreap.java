import java.util.List;
import java.util.Random;

/**
 *
 *
 *
 *
 * @author Steven Sheets    - smsheets@iastate.edu
 * @author Noah Frederiksen - nfred99@iastate.edu
 */
public class IntervalTreap extends Node{

    int treapSize;
    int treapHeight;
    Node root = new Node();

    /**
     * Constructor
     */
    public IntervalTreap() {
        treapSize = 0;
        treapHeight = 0;
        root = null;
    }

    /**
     *
     * Returns a reference to the root node.
     *
     * @return root node
     */
    public Node getRoot() {
        return root;
    }

    /**
     *
     * Returns the number of nodes in the treap
     *
     * @return size
     */
    public int getSize() {
        return treapSize;
    }

    /**
     *
     * Returns the height of the treap
     *
     * @return height
     */
    public int getHeight() {
        return treapHeight;
    }

    /**
     *
     * Adds node z, whose 'interv' attribute references an
     * Interval object, to the interval treap. This operation must maintain the required interval
     * treap properties. The expected running time of this method should be O(log n) on an n-node
     * interval treap.
     *
     * @param z
     */
    void intervalInsert(Node z) {
        //check and set max of node z and all descendent nodes

        Random rand = new Random();
        z.priority = rand.nextInt(50);

        if (root == null) {
            root = z;
        }

        treapSize++;
    }

    /**
     *
     * Removes node z from the interval treap. This operation
     * must maintain the required interval treap properties. The expected running time of this
     * method should be O(log n) on an n-node interval treap.
     *
     * @param z
     */
    void intervalDelete(Node z) {

    }

    /**
     *
     * Returns a reference to a node x in the interval
     * treap such that x.interv overlaps interval i, or null if no such element is in the treap.
     * This method must not modify the interval treap. The expected running time of this method
     * should be O(log n) on an n-node interval treap.
     *
     * @param i
     * @return node x
     */
    Node intervalSearch(Interval i) {
        Node x = new Node();
        return x;
    }

    /////////// EXTRA CREDIT METHODS \\\\\\\\\\\\

    /**
     *
     * Returns a reference to a Node object x
     * in the treap such that x.interv.low = i.low and x.interv.high = i.high, or null if
     * no such node exists. The expected running time of this method should be O(log n) on an
     * n-node interval treap.
     *
     * @param i
     * @return node x
     */
    Node intervalSearchExactly(Interval i) {
        Node x = new Node();
        return x;
    }

    /**
     *
     * Returns a list all intervals in
     * the treap that overlap i. This method must not modify the interval treap. The expected
     * running time of this method should be O(min(n, k log n)), where k is the number of intervals
     * in the output list.
     *
     * @param i
     * @return list of intervals
     */
    /*List<Interval> overalppingIntervals(Interval i) {
        List<Interval> intervalList = new List<>();
        return intervalList;
    }*/
}
