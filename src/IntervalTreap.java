import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents an interval treap.
 *
 * @author Steven Sheets    - smsheets@iastate.edu
 * @author Noah Frederiksen - nfred99@iastate.edu
 */
public class IntervalTreap {

    /** The root of this IntervalTreap. */
    private Node root;

    /** The size of this IntervalTreap. */
    private int size;

    /**
     * Constructs a new instance of this IntervalTreap class.
     */
    public IntervalTreap() {
        root = null;
        size = 0;
    }

    /**
     * Returns a reference to the root node.
     *
     * @return root - the root Node
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Returns the number of nodes in this IntervalTreap.
     *
     * @return size - The number of nodes in this IntervalTreap
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the height of this IntervalTreap.
     *
     * @return The height of this IntervalTreap
     */
    public int getHeight() {
        return root != null ? root.getHeight() : 0;
    }


    /**
     * Adds node z, whose 'interv' attribute references an Interval object, to
     * the interval treap. This operation must maintain the required interval
     * treap properties. The expected running time of this method should be
     * O(log n) on an n-node interval treap.
     *
     * @param z - The Node to insert into this IntervalTreap.
     */
    public void intervalInsert(Node z) {
        Node x = this.root;
        Node y = null;

        z.setPriority(new Random().nextInt(Integer.MAX_VALUE) + 1);
        z.setIMax(z.getInterv().getHigh());

        while (x != null) {
            y = x;
            x.setIMax(Math.max(x.getIMax(), z.getInterv().getHigh()));

            if (x.getLeft() == null && x.getRight() == null) {
                x.setHeight(0);
            } else if (x.getRight() == null) {
                x.setHeight(x.getLeft().getHeight() + 1);
            } else if (x.getLeft() == null) {
                x.setHeight(x.getRight().getHeight() + 1);
            } else {
                x.setHeight(Math.max(x.getRight().getHeight(), x.getLeft().getHeight()) + 1);
            }

            if (z.getInterv().getLow() < x.getInterv().getLow()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }

        z.setParent(y);

        if (y == null) {
            root = z;
        } else if (z.getInterv().getLow() < y.getInterv().getLow()) {
            y.setLeft(z);
        } else {
            y.setRight(z);
        }

        size++;

        // Clean up the IntervalTreap post insertion.
        while (z != root) {
            if (z.getPriority() < z.getParent().getPriority()) {
                if (z == z.getParent().getRight()) {
                    leftRotation(z);
                } else {
                    rightRotation(z);
                }
            } else {
                imaxAndHeightCorrector(z);
                z = z.getParent();
            }
        }
        imaxAndHeightCorrector(z);
    }

    /**
     * Removes Node z from the interval treap. This operation must maintain
     * the required interval treap properties. The expected running time of
     * this method should be O(log n) on an n-node interval treap.
     *
     * @param z - The Node to delete from this IntervalTree.
     */
    public void intervalDelete(Node z) {
        Node y = null;
        Node toReplace = z.getParent();
        boolean mustRotate = false;

        if (z.getLeft() == null) {
            transplant(z, z.getRight());
        } else if (z.getRight() == null) {
            transplant(z, z.getLeft());
        } else {
            mustRotate = true;
            y = Minimum(z.getRight());
            toReplace = z.getRight();
            if (y.getParent() != z) {
                toReplace = y.getRight();
                transplant(y, y.getRight());
                y.setRight(z.getRight());
                y.getRight().setParent(y);
            }
            transplant(z, y);
            y.setLeft(z.getLeft());
            y.getLeft().setParent(y);
        }

        // Rotate to satisfy v.priority > v.parent.priority, for every node v
        if (toReplace != null) {
            updateIMaxPostDeletion(toReplace);
        }

        // Clean up the IntervalTreap post deletion, if we must
        if (mustRotate) {
            while ((y.getLeft() != null && y.getPriority() > y.getLeft().getPriority())
                    || (y.getRight() != null && y.getPriority() > y.getRight().getPriority())) {
                if (y.getRight() == null && y.getLeft() != null) {
                    rightRotation(y.getLeft());
                } else if (y.getLeft() == null && y.getRight() != null) {
                    leftRotation(y.getRight());
                } else if (y.getLeft().getPriority() < y.getRight().getPriority()) {
                    rightRotation(y.getLeft());
                } else {
                    leftRotation(y.getRight());
                }
            }
            updateIMaxPostDeletion(y);
        }

        this.size--;
    }

    /**
     * Returns a reference to a Node x in the IntervalTreap such that x.interv
     * overlaps interval i, or null if no such element is in the treap. This
     * method must not modify the interval treap. The expected running time of
     * this method should be O(log n) on an n-node interval treap.
     *
     * @param i - The Interval to be used in this search such that the
     *            specifications in the description are met.
     * @return Node x - The Node that meets the specifications for this search,
     *                  null if no such element exists in this IntervalTreap.
     */
    public Node intervalSearch(Interval i) {
        Node x = root;
        while (x != null && !intervalsOverlap(x.getInterv(), i)) {
            if (x.getLeft() != null && x.getLeft().getIMax() >= i.getLow()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }
        return x;
    }


    /* ******** EXTRA CREDIT METHODS BELOW ********* */


    /**
     * Returns a reference to a Node object x in the treap such that
     * x.interv.low = i.low and x.interv.high = i.high, or null if
     * no such node exists. The expected running time of this method
     * should be O(log n) on an n-node interval treap.
     *
     * @param i - The Interval to be used in this search such that the
     *            specifications in the description are met.
     * @return Node x - The Node that meets the specifications for this search,
     *                  null if no such element exists in this IntervalTreap.
     */
    public Node intervalSearchExactly(Interval i) {
        Node x = root;
        while (x != null && !intervalsOverlapExactly(x.getInterv(), i)) {
            if (x.getLeft() != null && x.getLeft().getInterv().getLow() >= i.getLow())
                x = x.getLeft();
            else
                x = x.getRight();
        }

        return x;
    }


    /**
     * Returns a list all intervals in the treap that overlap i. This method
     * must not modify this IntervalTreap. The expected running time of this
     * method should be O(min(n, k log n)), where k is the number of intervals
     * in the output list.
     *
     * @param i - The Interval to be compared to all Intervals in this IntervalTreap
     *            to see if overlap occurs.
     * @return overlappingIntervalList - The list of intervals in this IntervalTreap
     *                                   that overlap i.
     */
    public List<Interval> overlappingIntervals(Interval i) {
        List<Interval> overlappingIntervalList = new ArrayList<>();
        // TODO

        return overlappingIntervalList;
    }


    /* ******** "NON-REQUIRED PRIVATE HELPER METHODS BELOW ********* */


    /**
     * Helper method for ensuring the height and imax values
     * of nodes are always the values they should be.
     *
     * @param x - Node to ensure the height and imax value is correct
     */
    public void imaxAndHeightCorrector(Node x) {
        if (x.getLeft() == null && x.getRight() == null) {
            x.setIMax(x.getInterv().getHigh());
            x.setHeight(0);
        } else if (x.getRight() == null) {
            x.setIMax(Math.max(x.getInterv().getHigh(), x.getLeft().getIMax()));
            x.setHeight(x.getLeft().getHeight() + 1);
        } else if (x.getLeft() == null) {
            x.setIMax(Math.max(x.getInterv().getHigh(), x.getRight().getIMax()));
            x.setHeight(x.getRight().getHeight() + 1);
        } else {
            x.setIMax(Math.max(x.getInterv().getHigh(), Math.max(x.getLeft().getIMax(), x.getRight().getIMax())));
            x.setHeight(Math.max(x.getRight().getHeight() + 1, x.getLeft().getHeight()) + 1);
        }
    }


    /**
     * Performs a left rotation on Node y, the node to the left.
     *
     * @param y - Node to perform a left rotation on
     */
    private void leftRotation(Node y) {
        Node x = y.getParent();
        y = x.getRight();
        x.setRight(y.getLeft());

        if (y.getLeft() != null) {
            y.getLeft().setParent(x);
        }

        y.setParent(x.getParent());

        if (x.getParent() == null) {
            root = y;
        } else if (x == x.getParent().getLeft()) {
            x.getParent().setLeft(y);
        } else {
            x.getParent().setRight(y);
        }

        y.setLeft(x);
        x.setParent(y);
        imaxAndHeightCorrector(x);
    }

    /**
     * Performs a right rotation on Node y, the node to the right.
     *
     * @param y - Node to perform a right rotation on
     */
    private void rightRotation(Node y) {
        Node x = y.getParent();
        y = x.getLeft();
        x.setLeft(y.getRight());

        if (y.getRight() != null) {
            y.getRight().setParent(x);
        }

        y.setParent(x.getParent());

        if (x.getParent() == null) {
            root = y;
        } else if (x == x.getParent().getRight()) {
            x.getParent().setRight(y);
        } else {
            x.getParent().setLeft(y);
        }

        y.setRight(x);
        x.setParent(y);

        imaxAndHeightCorrector(x);
    }

    /**
     * Helper method to check if the Interval of
     * Node x, xInterv, overlaps with Interval i.
     *
     * @param xInterv - The Interval to see if it overlaps with it
     * @param i - The Interval to see if xInterval overlaps with it
     * @return - True, if overlap occurs, otherwise False
     */
    private boolean intervalsOverlap(Interval xInterv, Interval i) {
        return (i.getLow() <= xInterv.getHigh() && xInterv.getLow() <= i.getHigh());
    }

    /**
     * Helper method to check if the Interval of
     * Node x, xInterv overlaps exactly with Interval i.
     *
     * @param xInterv - The Interval to see if it overlaps exactly with it
     * @param i - The Interval to see if xInterval overlaps exactly with it
     * @return - True, if overlap occurs, otherwise False
     */
    private boolean intervalsOverlapExactly(Interval xInterv, Interval i) {
        return (i.getLow() == xInterv.getLow() && i.getHigh() == xInterv.getHigh());
    }

    /**
     * Helper method to get the minimum key of a subtree rooted at Node n.
     *
     * @param n - Node to start with, searching for the minimum
     * @return min - The Node that in this IntervalTreap with the minimum key
     */
    private Node Minimum(Node n) {
        Node min = n;
        while (min.getLeft() != null) {
            min = min.getLeft();
        }
        return min;
    }

    /**
     * Performs a transplant operation on Nodes u and v.
     *
     * @param u - Node1 for the transplant operation
     * @param v - Node2 for the transplant operation
     */
    private void transplant(Node u, Node v) {
        if (u.getParent() == null) {
            root = v;
        } else if (u == u.getParent().getLeft()) {
            u.getParent().setLeft(v);
        } else {
            u.getParent().setRight(v);
        }

        if (v != null) {
            v.setParent(u.getParent());
        }
    }

    /**
     * Helper method to update the imax field of a Node post deletion.
     *
     * @param n - The node to be updated
     */
    private void updateIMaxPostDeletion(Node n) {
        imaxAndHeightCorrector(n);
        while (n != root) {
            n = n.getParent();
            imaxAndHeightCorrector(n);
        }
    }
}
