import java.util.ArrayList;
import java.util.List;

public class Node {

    private String name;
    // coordinates
    private double x, y;
    // parameters for A* search
    private double g, h, f; 
    // track the adjacent naeighbours
    private List<Edge> neighbours;
    //track previous node in shortest path
    private Node parent;

    public Node(String name, double x, double y)
    {
        this.name = name;
        this.x = x;
        this.y= y;
        this.neighbours = new ArrayList<>();

    }

    public double getX()
    {
        return x;

    }

    public void setX(double x)
    {
        this.x = x;

    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
        
    }

    public double getG()
    {
        return g;

    }

    public void setG(double g)
    {
        this.g = g;
        
    }

    public double getH()
    {
        return h;

    }

    public void setH(double h)
    {
        this.h = h;

    }

    public double getF()
    {
        return f;

    }

    public void setF(double f)
    {
        this.f = f;

    }

    public List<Edge> getNeighbours()
    {
        return neighbours;

    }

    public void addNeighbour(Edge edge)
    {
        this.neighbours.add(edge);

    }

    public Node getParent()
    {
        return parent;

    }

    public void setParent(Node parent)
    {
        this.parent = parent;

    }

    @Override
    public String toString()
    {
        return name;

    }

}
