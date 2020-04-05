/**
 * The Interval class represents intervals. To avoid problems with numerical
 * precision, the endpoints of intervals will be integers.
 *
 * @author Steven Sheets    - smsheets@iastate.edu
 * @author Noah Frederiksen - nfred99@iastate.edu
 */
public class Interval {

    /** The low endpoint of the Interval. */
    private int low;

    /** The high endpoint of the Interval. */
    private int high;

    /**
     * Constructs a new instance of this Interval class.
     *
     * @param low - The low endpoint of the Interval
     * @param high - The high endpoint of the Interval
     */
    public Interval(int low, int high) {
        this.low = low;
        this.high = high;
    }

    /**
     * Returns the low endpoint of this Interval.
     *
     * @return - The low endpoint of this Interval
     */
    public int getLow() {
        return low;
    }

    /**
     * Returns the high endpoint of this Interval.
     *
     * @return - The high endpoint of this Interval
     */
    public int getHigh() {
        return high;
    }

    /* ******** "NON-REQUIRED" METHODS BELOW ********* */

    /**
     * Sets the low endpoint of this Interval.
     *
     * @param low - The new low endpoint of this Interval
     */
    public void setLow(int low) {
        this.low = low;
    }

    /**
     * Sets the high endpoint of this Interval.
     *
     * @param high - The new high endpoint of this Interval
     */
    public void setHigh(int high) {
        this.high = high;
    }
}
