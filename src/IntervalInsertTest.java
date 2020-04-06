public class IntervalInsertTest {
    public static void main(String[] args) {
        IntervalTreap tree = new IntervalTreap();

        Interval i1 = new Interval(16, 21);
        Interval i2 = new Interval(16, 35);

        Node n1 = new Node(i1);
        Node n2 = new Node(i2);

        tree.intervalInsert(n1);
        tree.intervalInsert(n2);

        System.out.println(n1.getPriority());
        System.out.println(n2.getPriority());
    }
}
