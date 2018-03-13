package usejava;

/**
 * Created by cbw on 2018/3/11.
 * 顶点类定义成泛型，vertex是每个顶点存的对象，id是每个顶点的id
 */
public class Vertex<T> {

    private T vertex;
    private int id;

    public Vertex(T vertex, int id) {
        this.vertex = vertex;
        this.id = id;
    }

    public T getVertex() {
        return vertex;
    }

    public void setVertex(T vertex) {
        this.vertex = vertex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
