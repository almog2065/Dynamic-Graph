public class DynamicGraph {
    private DoublyLinkedList<GraphNode> NodeList;
    private DoublyLinkedList<GraphNode> bfsList;
    private DoublyLinkedList<GraphNode> dfsList;


    public DoublyLinkedList<GraphNode> getNodeList() {
        return NodeList;
    }

    public DoublyLinkedList<GraphNode> getBfsList() {
        return bfsList;
    }

    public DoublyLinkedList<GraphNode> getDfsList() {
        return dfsList;
    }



    public DynamicGraph(){
        this.NodeList = new DoublyLinkedList<>();
        this.bfsList = new DoublyLinkedList<>();
        this.dfsList = new DoublyLinkedList<>();
    }

    public GraphNode insertNode(int nodeKey){
        GraphNode node = new GraphNode(nodeKey);
        node.setListNode(NodeList.insert(node));
        return node;
    }

    public void deleteNode(GraphNode node){
        if (node.getOutEdges().getSize() == 0 && node.getInEdges().getSize() == 0)
            NodeList.delete(node.getNodeList());
    }

    public GraphEdge insertEdge(GraphNode from, GraphNode to){
        GraphEdge edge = new GraphEdge(from,to);
        edge.setOutEdgeList(from.getOutEdges().insert(edge));
        edge.setInEdgeList(to.getInEdges().insert(edge));
        return edge;
    }

    public void deleteEdge (GraphEdge edge){
        edge.getFrom().getOutEdges().delete(edge.getOutEdgeList());
        edge.getTo().getInEdges().delete(edge.getInEdgeList());
    }

    public void bfsInitialization(GraphNode source){
        if (source != null) {
            DoublyLinkedList.Node<GraphNode> temp = NodeList.getHead();
            GraphNode vertex;
            while (temp != null) {
                vertex = temp.getValue();
                if (vertex.getKey() != source.getKey()) {
                    vertex.setColor("white");
                    vertex.setDistance(Integer.MAX_VALUE);
                    vertex.setParent(null);
                }
                temp = temp.getNext();
            }
            source.setColor("gray");
            source.setDistance(0);
            source.setParent(null);
            bfsList.insert(source);
        }
    }

    public RootedTree bfs(GraphNode source){
        RootedTree shortestPathsTree = new RootedTree();
        bfsInitialization(source);
        boolean firstNeighbour;
        DoublyLinkedList<TreeNode> currentInTree = new DoublyLinkedList<>();
        currentInTree.insert(new TreeNode(bfsList.getHead().getValue().getKey()));
        TreeNode newNode;
        while (bfsList.getSize() > 0){
            GraphNode u = bfsList.extract();
            newNode = currentInTree.extract();
            if (u.equals(source))
                shortestPathsTree.setRoot(newNode);
            DoublyLinkedList.Node<GraphEdge> position = u.getOutEdges().getHead();
            GraphNode neighbour;
            firstNeighbour = true;
            while (position != null){
                neighbour = position.getValue().getTo();
                if (neighbour.getColor().equals("white")){
                    neighbour.setColor("gray");
                    neighbour.setDistance(u.getDistance()+1);
                    neighbour.setParent(u);
                    bfsList.insert(neighbour);
                    if (firstNeighbour) {
                        firstNeighbour = false;
                        TreeNode node = new TreeNode(neighbour.getKey());
                        newNode.addLeftChild(node,newNode);
                        currentInTree.insert(node);
                        newNode = newNode.getLeftChild();
                    }
                    else{
                        TreeNode node = new TreeNode(neighbour.getKey());
                        newNode.addRightSibling(node);
                        currentInTree.insert(node);
                        newNode = newNode.getRightSibling();
                    }
                }
                position = position.getNext();
            }
            u.setColor("black");
        }
        return shortestPathsTree;
    }

    public void dfsInitialization(boolean isTransposed){
        DoublyLinkedList.Node<GraphNode> position = this.NodeList.getHead();
        if (!isTransposed)
            this.dfsList = new DoublyLinkedList<>();
        while (position != null){
            position.getValue().setColor("white");
            position.getValue().setParent(null);
            position = position.getNext();
        }
    }

    public DoublyLinkedList<RootedTree> dfs(boolean isTransposed){
        dfsInitialization(isTransposed);
        int time = 0;
        DoublyLinkedList.Node<GraphNode> position;
        if (!isTransposed) {
            position = this.NodeList.getHead();
        }
        else{
            position = this.dfsList.getHead();
        }
        DoublyLinkedList<RootedTree> trees = new DoublyLinkedList<>();

        while (position != null){
            if (position.getValue().getColor().equals("white")){
                RootedTree newTree = new RootedTree();
                TreeNode root = new TreeNode(position.getValue().getKey());
                newTree.setRoot(root);
                time = dfs_Visit(position.getValue(),time,root, isTransposed);
                trees.insert(newTree);
            }
            position = position.getNext();
        }
        return trees;
    }

    public int dfs_Visit(GraphNode vertex, int time, TreeNode root, boolean isTransposed){
        time = time + 1;
        vertex.setDiscovery(time);
        vertex.setColor("gray");
        DoublyLinkedList.Node<GraphEdge> position;
        GraphNode neighbour;
        if (!isTransposed)
            position = vertex.getOutEdges().getHead();
        else
            position = vertex.getInEdges().getHead();
        boolean firstNeighbour = true;
        while (position != null){
            if (isTransposed)
                neighbour = position.getValue().getFrom();
            else
                neighbour = position.getValue().getTo();
            if (neighbour.getColor().equals("white")){
                if (firstNeighbour){
                    firstNeighbour = false;
                    neighbour.setParent(vertex);
                    TreeNode neighbourAsTreeNode = new TreeNode(neighbour.getKey());
                    root.addLeftChild(neighbourAsTreeNode,root);
                    time = dfs_Visit(neighbour,time,neighbourAsTreeNode,isTransposed);
                }

                else{
                    neighbour.setParent(vertex);
                    TreeNode neighbourAsTreeNode = new TreeNode(neighbour.getKey());
                    root.getLeftChild().addRightSibling(neighbourAsTreeNode);
                    time = dfs_Visit(neighbour,time,neighbourAsTreeNode,isTransposed);
                }
            }
            position = position.getNext();
        }
        vertex.setColor("black");
        time++;
        vertex.setRetraction(time);
        if (!isTransposed)
            this.dfsList.insert(vertex);
        return time;
    }

   public RootedTree scc(){
        dfs(false);
        DoublyLinkedList<RootedTree> trees = dfs(true);
        RootedTree newTree = new RootedTree();
        TreeNode root = new TreeNode(0);
        newTree.setRoot(root);
        boolean firstTree = true;
        DoublyLinkedList.Node<RootedTree> position = trees.getTail();
        TreeNode current = root;
        while (position != null){
            if (firstTree){
                firstTree = false;
                root.addLeftChild(position.getValue().getRoot(),root);
                current = root.getLeftChild();
            }
            else{
                current.addRightSibling(position.getValue().getRoot());
                current = current.getRightSibling();
            }
            position = position.getPrev();
        }
        return newTree;
   }
}
