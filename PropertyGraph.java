package usejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by cbw on 2018/3/11.
 * 通过传递过来的表构造图
 */
public class PropertyGraph {

    private ArrayList<GraphHelper> helperList;

    public PropertyGraph(ArrayList<GraphHelper> helperList) {
        this.helperList = helperList;
    }


    public ArrayList<GraphHelper> getHelperList() {
        return helperList;
    }

    public void setHelperList(ArrayList<GraphHelper> helperList) {
        this.helperList = helperList;
    }

    //返回某一类型的所有顶点的id
    public HashSet<Integer> getVertexByType(Class classType) {
        HashSet<Integer> set = new  HashSet();
        for(GraphHelper helper:helperList){
            if(helper.getV1().getVertex().getClass().equals(classType)){
                set.add(helper.getV1().getId());
            }
            if(helper.getV2().getVertex().getClass().equals(classType)){
                set.add(helper.getV2().getId());
            }
        }
        return set;
    }

    //返回某一属性为特定值的对象的图中的id，如查找所有年龄为12的Person
    public HashSet<Integer> getVertexByTypeAndAttribute(Class classType, int tag) {
        HashSet<Vertex> temp = new  HashSet();
        HashSet<Integer> set = new HashSet();
        for(GraphHelper helper:helperList){
            if(helper.getV1().getVertex().getClass().equals(classType)){
                temp.add(helper.getV1());
            }
            if(helper.getV2().getVertex().getClass().equals(classType)){
                temp.add(helper.getV2());
            }
        }
        for(Vertex v:temp){
            People p = (People) v.getVertex();
            if(p.getAge()==tag){
                set.add(v.getId());
            }
        }

        return set;
    }

    HashMap<Integer,Integer> map = new HashMap(); //用来保存权值矩阵和真实顶点id之间的关系
    //建立权值矩阵
    int size;
    private double[][] toWeightArray() {
        HashSet<Vertex> set = new HashSet();
        for (GraphHelper helper:helperList){
            set.add(helper.getV1());
            set.add(helper.getV2());
        }
        size = set.size();
        //测试
        //System.out.println("size:"+size);
        double[][] arr = new double[size][size];
        for (int m=0;m<size;m++){
            for (int n=0;n<size;n++){
                if (m==n){
                    arr[m][n] = 0;
                }else {
                    arr[m][n] = -1;
                }
            }
        }
        int i=0;
        for (GraphHelper helper:helperList){
            int m = 0;
            int n = 0;
            if (!map.containsValue(helper.getV1().getId())){
                map.put(i,helper.getV1().getId());
                m = i++;
            }else {
                for (int j=0;j<size;j++){
                    if (map.get(j)==helper.getV1().getId()){
                        m = j;
                        break;
                    }
                }
            }
            if (!map.containsValue(helper.getV2().getId())){
                map.put(i,helper.getV2().getId());
                n = i++;
            }else {
                for (int j=0;j<size;j++){
                    if (map.get(j)==helper.getV2().getId()){
                        n = j;
                        break;
                    }
                }
            }
            arr[m][n] = helper.getEdge().getLength();
            arr[n][m] = helper.getEdge().getLength();
        }
        //测试
        /*for (int m=0;m<size;m++){
            for (int j=0;j<size;j++){
                System.out.print(arr[m][j]+"  ");
                if (j==size-1){
                    System.out.println();
                }
            }
        }*/
        return arr;
    }

    //Dijkstra算法求加权无向图的最短路径
    public double getMinPath(int ori,int des){
        double[][] W1 = toWeightArray(); //先建立权值矩阵
        int start = 0;
        int end = 0;
        for (int j=0;j<size;j++){
            if (map.containsKey(j) && map.get(j)==ori){
                start = j;
                //System.out.println(start);
            }
            if (map.containsKey(j) && map.get(j)==des){
                end = j;
                //System.out.println(end);
            }
        }
        if (start>=size || end>=size){
            return -1;
        }
        if (start==end){
            return 0.0;
        }
        boolean[] isLabel = new boolean[W1[0].length];// 是否标号
        int[] indexs = new int[W1[0].length];// 所有标号的点的下标集合，以标号的先后顺序进行存储，实际上是一个以数组表示的栈
        int i_count = -1;//栈的顶点
        double[] distance = W1[start].clone();// v0到各点的最短距离的初始值
        int index = start;// 从初始点开始
        double presentShortest = 0;//当前临时最短距离

        indexs[++i_count] = index;// 把已经标号的下标存入下标集中
        isLabel[index] = true;

        while (i_count<W1[0].length) {
            // 第一步：标号v0,即w[0][0]找到距离v0最近的点

            double min = Double.MAX_VALUE;
            for (int i = 0; i < distance.length; i++) {
                if (!isLabel[i] && distance[i] != -1 && i != index) {
                    // 如果到这个点有边,并且没有被标号
                    if (distance[i] < min) {
                        min = distance[i];
                        index = i;// 把下标改为当前下标
                    }
                }
            }
            if (index == end) {//已经找到当前点了，就结束程序
                break;
            }
            isLabel[index] = true;//对点进行标号
            indexs[++i_count] = index;// 把已经标号的下标存入下标集中
            if (W1[indexs[i_count - 1]][index] == -1
                    || presentShortest + W1[indexs[i_count - 1]][index] > distance[index]) {
                // 如果两个点没有直接相连，或者两个点的路径大于最短路径
                presentShortest = distance[index];
            } else {
                presentShortest += W1[indexs[i_count - 1]][index];
            }

            // 第二步：将distance中的距离加入vi
            for (int i = 0; i < distance.length; i++) {
                // 如果vi到那个点有边，则v0到后面点的距离加
                if (distance[i] == -1 && W1[index][i] != -1) {// 如果以前不可达，则现在可达了
                    distance[i] = presentShortest + W1[index][i];
                } else if (W1[index][i] != -1
                        && presentShortest + W1[index][i] < distance[i]) {
                    // 如果以前可达，但现在的路径比以前更短，则更换成更短的路径
                    distance[i] = presentShortest + W1[index][i];
                }

            }
        }
        //如果全部点都遍历完，则distance中存储的是开始点到各个点的最短路径
        return distance[end] - distance[start];
    }

}
