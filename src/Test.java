/**
 *
 *
 *
 *
 * @author Steven Sheets    - smsheets@iastate.edu
 * @author Noah Frederiksen - nfred99@iastate.edu
 */
public class Test {
    public static void main(String[] args) {



        Node node1 = new Node(new Interval(3, 6));
        Node node2 = new Node(new Interval(4, 9));
        Node node3 = new Node(new Interval(1, 2));

        IntervalTreap intTreap = new IntervalTreap();

        intTreap.intervalInsert(node1);

        System.out.println(intTreap.getSize());
        System.out.println(intTreap.getHeight());
        System.out.println(intTreap.getRoot().getIMax());
        System.out.println(intTreap.getRoot().getPriority());

        System.out.println("[" + intTreap.getRoot().getInterval().getLow() +
                            ", " + intTreap.getRoot().getInterval().getHigh() + "]");


    }
}
