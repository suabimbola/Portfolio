import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class AStarSearch {

    private Node source;
    private Node destination;
    private Set<Node> explored;
    private PriorityQueue<Node> pq;

    public AStarSearch(Node source, Node destination)
    {
        this.source = source;
        this.destination = destination;
        this.explored = new HashSet<>();
        this.pq = new PriorityQueue<>(new CompareNode());
        
    }

    public void init()
    {
        pq.add(source);

        while(!pq.isEmpty())
        {
            //get node with lowest f value
            Node current = pq.poll();
            explored.add(current);

            //reached destination node
            if (current == destination)
                break;

            for(Edge edge : current.getNeighbours())
            {
                Node child = edge.getTarget();
                double cost = edge.getWeight();
                double tempG = current.getG() + cost;
                double tempF = tempG + h(current,destination);
                
                if(explored.contains(child) && tempF >= child.getF())
                {
                    continue;

                }
                
                //if not visited and f score is lower
                else if(!pq.contains(child) || tempF < child.getF())
                {
                    //trach shortest path
                    child.setParent(current);
                    child.setG(tempG);
                    child.setF(tempF);

                    //remove previous occurences to update values
                    if (pq.contains(child))
                    {
                        pq.remove(child);

                    }

                    pq.add(child);
                }

            }
        }
    }

    private double h(Node node1, Node node2) {
        return Math.sqrt(((node1.getX()-node2.getX())*(node1.getX()-node2.getX()))+((node1.getY()-node2.getY())*(node1.getY()-node2.getY())));
    }

    public void SoluionPath()
    {
        List<Node> path = new ArrayList<>();

        for(Node node=destination; node!=null; node=node.getParent())
        {
            path.add(node);

        }

        Collections.reverse(path);

        System.err.println(path);

    }

}