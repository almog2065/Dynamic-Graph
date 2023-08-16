# Dynamic-Graph

This repository contains an implementation of a dynamic graph data structure called `DynamicGraph`, designed to efficiently handle various graph operations. Additionally, the repository includes implementations of a `DoublyLinkedList` data structure and a `RootedTree` class.

## Table of Contents
- [Introduction](#introduction)
- [Classes and Methods](#classes-and-methods)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The `DynamicGraph` class is the central component of this implementation. It provides functionalities for managing nodes, edges, and performing various graph operations efficiently. The graph supports Breadth-First Search (BFS), Depth-First Search (DFS), and Strongly Connected Components (SCC) computation. The repository also includes a `DoublyLinkedList` class for managing lists and a `RootedTree` class for representing rooted trees.

## Classes and Methods

### `DynamicGraph`

- **Constructor**: Initializes an empty dynamic graph and associated lists.
- `insertNode(int nodeKey)`: Inserts a new graph node with the specified key.
- `deleteNode(GraphNode node)`: Deletes the given graph node and its associated edges if applicable.
- `insertEdge(GraphNode from, GraphNode to)`: Inserts a directed edge from one node to another.
- `deleteEdge(GraphEdge edge)`: Deletes the specified edge.
- `bfs(GraphNode source)`: Performs Breadth-First Search traversal starting from the specified node.
- `dfs(boolean isTransposed)`: Performs Depth-First Search traversal, optionally considering transposed edges.
- `scc()`: Computes Strongly Connected Components using two DFS traversals.

### `GraphNode`

- `getOutDegree()`: Returns the out-degree of the node.
- `getInDegree()`: Returns the in-degree of the node.
- `getKey()`: Returns the key of the node.

### `GraphEdge`

- Represents a directed edge between two nodes.

### `RootedTree`

- Represents a rooted tree structure.
- `getRoot()`: Returns the root of the rooted tree.
- `setRoot(TreeNode root)`: Sets the root of the rooted tree.
- `printByLayer(DataOutputStream out)`: Prints the tree nodes by layer to the specified data output stream.
- `preorderPrint(DataOutputStream out)`: Prints the tree nodes in preorder to the specified data output stream.

### `DoublyLinkedList`

- A doubly linked list implementation for managing lists.

## Usage

You can use the `DynamicGraph` class to create, manage, and analyze dynamic graphs efficiently. The `DoublyLinkedList` class is available for handling linked lists, and the `RootedTree` class provides functionalities for working with rooted trees. The `DynamicGraph` class offers methods for adding and deleting nodes and edges, as well as performing BFS, DFS, and SCC calculations. Refer to the source code for examples of usage.

## Contributing

Contributions to this repository are encouraged! If you find bugs, have suggestions for improvements, or want to extend the functionality, please create a pull request. Make sure to follow coding conventions and include relevant tests.

## License

This project is licensed under the [MIT License](LICENSE).
