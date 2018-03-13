package usejava;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by cbw on 2018/3/11.
 */
public class TestMain {

    public static void main(String[] args) {
        //功能1测试
        /*Vertex v0 = new Vertex("V0",0);
        Vertex v1 = new Vertex("V1",1);
        Vertex v2 = new Vertex("V2",2);
        Vertex v4 = new Vertex("V4",4);
        Edge edge01 = new Edge("edge",1);
        Edge edge02 = new Edge("edge",4);
        Edge edge12 = new Edge("edge",2);
        Edge edge24 = new Edge("edge",1);
        Edge edge14 = new Edge("edge",5);
        GraphHelper helper1 = new GraphHelper(v0,v1,edge01);
        GraphHelper helper2 = new GraphHelper(v0,v2,edge02);
        GraphHelper helper3 = new GraphHelper(v1,v2,edge12);
        GraphHelper helper4 = new GraphHelper(v2,v4,edge24);
        GraphHelper helper5 = new GraphHelper(v1,v4,edge14);
        ArrayList<GraphHelper> helperList = new ArrayList();
        helperList.add(helper1);
        helperList.add(helper2);
        helperList.add(helper3);
        helperList.add(helper4);
        helperList.add(helper5);
        PropertyGraph graph = new PropertyGraph(helperList);
        HashSet<Integer> set = graph.getVertexByType(String.class);
        for(Integer i:set){
            System.out.println(i);
        }*/

        //功能2测试
        /*People p1 = new People(11);
        People p2 = new People(12);
        Vertex v1 = new Vertex(p1,1);
        Vertex v2 = new Vertex(p2,2);
        Edge edge = new Edge("edge",3);
        GraphHelper helper = new GraphHelper(v1,v2,edge);
        ArrayList<GraphHelper> helperList = new ArrayList();
        helperList.add(helper);
        PropertyGraph graph = new PropertyGraph(helperList);
        HashSet<Integer> set = graph.getVertexByTypeAndAttribute(People.class,12);
        for(Integer i:set){
            System.out.println(i);
        }*/

        //功能3测试
        Vertex v0 = new Vertex("V0",0);
        Vertex v1 = new Vertex("V1",1);
        Vertex v2 = new Vertex("V2",2);
        Vertex v4 = new Vertex("V4",4);
        Edge edge01 = new Edge("edge",1);
        Edge edge02 = new Edge("edge",4);
        Edge edge12 = new Edge("edge",2);
        Edge edge24 = new Edge("edge",1);
        Edge edge14 = new Edge("edge",5);
        GraphHelper helper1 = new GraphHelper(v0,v1,edge01);
        GraphHelper helper2 = new GraphHelper(v0,v2,edge02);
        GraphHelper helper3 = new GraphHelper(v1,v2,edge12);
        GraphHelper helper4 = new GraphHelper(v2,v4,edge24);
        GraphHelper helper5 = new GraphHelper(v1,v4,edge14);
        ArrayList<GraphHelper> helperList = new ArrayList();
        helperList.add(helper1);
        helperList.add(helper2);
        helperList.add(helper3);
        helperList.add(helper4);
        helperList.add(helper5);
        PropertyGraph graph = new PropertyGraph(helperList);
        double result = graph.getMinPath(1,4);
        System.out.println(result);
    }
}
