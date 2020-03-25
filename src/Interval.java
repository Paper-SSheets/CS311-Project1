/**
 *
 *
 *
 *
 * @author Steven Sheets    - smsheets@iastate.edu
 * @author Noah Frederiksen - nfred99@iastate.edu
 */
public class Interval {

    int low;
    int high;

    /**
     * Empty interval constructor which takes the form [a,b]
     * where a ≤ b
     */
    public Interval() {
        new Interval(0, 0);
    }

    /**
     * Interval consturctor wtih the following params
     * @param low - lowest value of interval
     * @param high - highest value of interval
     */
    public Interval(int low, int high) {
        this.low = low;
        this.high = high;
    }

    /**
     *
     *  Return the lowest value of interval
     *
     * @return low value
     */
    public int getLow() {
        return low;
    }

    /**
     *
     *  Return the highest value of interval
     *
     * @return high value
     */
    public int getHigh() {
        return high;
    }
}


