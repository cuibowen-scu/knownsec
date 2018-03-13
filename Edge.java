package usejava;

/**
 * Created by cbw on 2018/3/11.
 * 边类定义成泛型，edge为边存的对象，length是边的权值
 */
public class Edge<T> {

    private T edge;
    private double length;

    public Edge(T edge, double length) {
        this.edge = edge;
        this.length = length;
    }

    public T getEdge() {
        return edge;
    }

    public void setEdge(T edge) {
        this.edge = edge;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
