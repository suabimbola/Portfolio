import java.util.Comparator;

public class CompareNode implements Comparator<Node> {

    //return node with lowest f value.
    @Override
    public int compare(Node o1, Node o2) {
        return Double.compare(o1.getF(), o2.getF());
        
    }

    

}