# knownsec

接口说明
1、PropertyGraph对象构建说明
第一步：
用户构建PropertyGraph对象需要先构建顶点Vertex对象和Edge对象，其中
Vertex（obj,id）:obj为任一类型的对象，id为用户自定义的顶点id，需要传入非负整数
Edge（obj,length）:obj为任一类型的对象，length为这条边的权值
第二步：
将Vertex和Edge封装成一个个GraphHelper，图中每一条线段为一个GraphHelper对象，其中
GraphHelper(V0,V1,edge):V0和V1为刚刚构建好的顶点，Edge为这两个顶点之间的边对象
第三步：
将所有构建好的Helper封装到一个ArrayList<GraphHelper>中，传入PropertyGraph，构造PropertyGraph对象，如
ArrayList<GraphHelper> helperList = new ArrayList();
helperList.add(helper1);
helperList.add(helper2);
helperList.add(helper3);
helperList.add(helper4);
helperList.add(helper5);
PropertyGraph graph = new PropertyGraph(helperList);


三个功能说明
功能1：返回某一类型的所有顶点的id，getVertexByType（）方法，传入class类型，如People.class,返回一个HashSet<Integer>,存储满足条件顶点的id集合
HashSet<Integer> set = graph.getVertexByType(String.class);

功能2：返回某一属性为特定值的对象的图中的id，如查找所有年龄为12的Person，传入class类别（xxx.class）和年龄大小（int类型），返回一个HashSet<Integer>，存储满足条件顶点的id集合：
HashSet<Integer> set = graph.getVertexByTypeAndAttribute(People.class,12);

功能3：求加权无向图的最短路径，输入想查找的两个顶点的id，返回最短路径double值：
double result = graph.getMinPath(1,4);
