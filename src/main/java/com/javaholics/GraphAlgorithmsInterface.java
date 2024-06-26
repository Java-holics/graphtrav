package com.javaholics;

/**
 * An interface of methods that process graphs.
 * 
 * @author Lindsay Kislingbury
 * @author Lea Wiranatha
 */
public interface GraphAlgorithmsInterface<T> {
    /**
     * Performs a breadth-first traversal of this graph.
     * 
     * @param origin An object that labels the origin vertex of the traversal.
     * @return A queue of labels of the vertices in the traversal, with
     *         the label of the origin vertex at the queue's front.
     */
    public QueueInterface<T> getBreadthFirstTraversal(T origin);

    /**
     * Performs a depth-first traversal of this graph.
     * 
     * @param origin An object that labels the origin vertex of the traversal.
     * @return A queue of labels of the vertices in the traversal, with
     *         the label of the origin vertex at the queue's front.
     */
    public QueueInterface<T> getDepthFirstTraversal(T origin);

} // end GraphAlgorithmsInterface