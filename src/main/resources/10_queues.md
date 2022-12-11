---
title:  Queues
date: 2022-09-15
----

Queue - A structure in which elements are added to the rear and removed from the front; a “first in, first out” (FIFO) structure

Queue operations: 

```
Constructor
new - creates an empty queue
Transformers
enqueue - adds an element to the rear of a queue
dequeue - removes and returns the front element of the queue 
```

```java
public interface QueueInterface<T>
{
  void enqueue(T element) throws QueueOverflowException;
  // Throws QueueOverflowException if this queue is full;
  // otherwise, adds element to the rear of this queue.

  T dequeue() throws QueueUnderflowException;
  // Throws QueueUnderflowException if this queue is empty;
  // otherwise, removes front element from this queue and returns it.

  boolean isFull();
  // Returns true if this queue is full; otherwise, returns false.

  boolean isEmpty();
  // Returns true if this queue is empty; otherwise, returns false.
  
  int size();
  // Returns the number of elements in this queue.
}
```