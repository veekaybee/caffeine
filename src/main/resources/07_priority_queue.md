---
title: Priority queue ADT
date: 2022-11-14
----

Priority queue - abstract data type with highest-priority element can be accessed. As events are 
generated, they are enqueued with a priority level equal to the tie the event takes place

Interface for a Priority queue: 

```java
package ch09.priorityQueues;

public interface PriQueueInterface<T>
{
  void enqueue(T element); 
  // Throws PriQOverflowException if this priority queue is full;
  // otherwise, adds element to this priority queue.

  T dequeue();
  // Throws PriQUnderflowException if this priority queue is empty;
  // otherwise, removes element with highest priority from this 
  // priority queue and returns it.

  boolean isEmpty();
  // Returns true if this priority queue is empty; otherwise, returns false.

  boolean isFull();
  // Returns true if this priority queue is full; otherwise, returns false.
 
  int size();
  // Returns the number of elements in this priority queue.
}

```

Difference between queue and priority queue is how the deque operation implemented. Priority
queue does not allow FIFO, always highest-priority element. In our case, the largest element. 


Implementations of priority queues: 

1. Unsorted Arrays - enqueing is easy, dequeueing is hard
2. Sorted Arrays  - last element is largest in a sorted array, O(1) operation
3. Sorted Linked List - dequeuing is easiest because it's already sorted
4. Binary search tree - tree insert operation - largest element is the rightmost tree element
Works really well unless the tree is skewed

Heap - imlementation of priority queue that uses binary tree that has two properties: 
1. full binary tree: all leaves on the same level and eery non-leaf node has two children
2. complete; full or full through the next-to-last level

Shape: underlying tree must be a complete binary tree; 
order: for every node in the tree, value stored in 
that node is greater than or equal to the value of the children