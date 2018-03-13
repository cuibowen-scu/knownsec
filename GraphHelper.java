package usejava;

/**
 * Created by cbw on 2018/3/11.
 * helper存储每一条边和两个顶点
 */
public class GraphHelper {

    private Vertex v1;
    private Vertex v2;
    private Edge edge;

    public GraphHelper(Vertex v1, Vertex v2, Edge edge) {
        this.v1 = v1;
        this.v2 = v2;
        this.edge = edge;
    }

    public Vertex getV1() {
        return v1;
    }

    public void setV1(Vertex v1) {
        this.v1 = v1;
    }

    public Vertex getV2() {
        return v2;
    }

    public void setV2(Vertex v2) {
        this.v2 = v2;
    }

    public Edge getEdge() {
        return edge;
    }

    public void setEdge(Edge edge) {
        this.edge = edge;
    }
}
