public class GraphEdge {
    private GraphNode from;
    private GraphNode to;
    private DoublyLinkedList.Node<GraphEdge> outEdgeList;
    private DoublyLinkedList.Node<GraphEdge> inEdgeList;
    private boolean isTransposed;

    public GraphNode getFrom() {
        return from;
    }

    public void setFrom(GraphNode from) {
        this.from = from;
    }

    public GraphNode getTo() {
        return to;
    }

    public void setTo(GraphNode to) {
        this.to = to;
    }

    public DoublyLinkedList.Node<GraphEdge> getOutEdgeList() {
        return outEdgeList;
    }

    public void setOutEdgeList(DoublyLinkedList.Node<GraphEdge> outEdgeList) {
        this.outEdgeList = outEdgeList;
    }

    public DoublyLinkedList.Node<GraphEdge> getInEdgeList() {
        return inEdgeList;
    }

    public void setInEdgeList(DoublyLinkedList.Node<GraphEdge> inEdgeList) {
        this.inEdgeList = inEdgeList;
    }

    public boolean isTransposed() {
        return isTransposed;
    }

    public void setTransposed(boolean transposed) {
        isTransposed = transposed;
    }



    public GraphEdge (GraphNode from, GraphNode to){
        this.from = from;
        this.to = to;
        this.outEdgeList = null;
        this.inEdgeList = null;
        this.isTransposed = false;
    }


}
