public class GraphNode{
    private DoublyLinkedList<GraphEdge> inEdges;
    private DoublyLinkedList<GraphEdge> outEdges;
    private final int key;
    private DoublyLinkedList.Node<GraphNode> nodeList;
    private String color;
    private int distance;
    private GraphNode parent;
    private int discovery;
    private int retraction;

    public GraphNode(int nodeKey){
        this.inEdges = new DoublyLinkedList<>();
        this.outEdges = new DoublyLinkedList<>();
        this.key = nodeKey;
        this.nodeList = null;
    }

    public DoublyLinkedList<GraphEdge> getInEdges() {
        return inEdges;
    }


    public DoublyLinkedList<GraphEdge> getOutEdges() {
        return outEdges;
    }


    public int getKey() {
        return key;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public GraphNode getParent() {
        return parent;
    }

    public void setParent(GraphNode parent) {
        this.parent = parent;
    }

    public int getDiscovery() {
        return discovery;
    }

    public void setDiscovery(int discovery) {
        this.discovery = discovery;
    }

    public int getRetraction() {
        return retraction;
    }

    public void setRetraction(int retraction) {
        this.retraction = retraction;
    }

    public int getOutDegree(){
        return outEdges.getSize();
    }

    public int getInDegree(){
        return inEdges.getSize();
    }

    public DoublyLinkedList.Node<GraphNode> getNodeList(){
        return this.nodeList;
    }

    public void setListNode (DoublyLinkedList.Node<GraphNode> node){
        this.nodeList = node;
    }

}
