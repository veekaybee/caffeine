---
title: List ADT
date: 2022-10-01
----

Lists are collections of elements with linear relationships 
between their elements. Each element in a list except the first
one has a unique predecessor and each element has a unique
successsor. 

+ Elements of a list are indexed sequentially
+ Can iterate linearly through a list from the first to the last element
    - Java interfaces of iteration: `Iterable` in `java.lang`
    - An iterator provides `hasNext`, `next` and `remove`
+ Each method that accepts an index as an argument throws an exception (IndexOutOfBoundsException) if the index is invalid


List Interface: 

```java
public interface ListInterface<T> extends CollectionInterface<T>, Iterable<T>
{
  void add(int index, T element);
  // Throws IndexOutOfBoundsException if passed an index argument
  // such that index < 0 or index > size().
  // Otherwise, adds element to this list at position index; all current 
  // elements at that position or higher have 1 added to their index.
  // Optional. Throws UnsupportedOperationException if not supported.
  
  T set(int index, T newElement);
  // Throws IndexOutOfBoundsException if passed an index argument
  // such that index < 0 or index >= size().
  // Otherwise, replaces element on this list at position index with
  // newElement and returns the replaced element.
  // Optional. Throws UnsupportedOperationException if not supported.
    
  T get(int index);
  // Throws IndexOutOfBoundsException if passed an index argument
  // such that index < 0 or index >= size().
  // Otherwise, returns the element on this list at position index.
  
  int indexOf(T target);
  // If this list contains an element e such that e.equals(target), 
  // then returns the index of the first such element.
  // Otherwise, returns -1.
  
  T remove(int index);
  // Throws IndexOutOfBoundsException if passed an index argument
  // such that index < 0 or index >= size().
  // Otherwise, removes element on this list at position index and
  // returns the removed element; all current elements at positions
  // higher than index have 1 subtracted from their position.
}
```

Enhanced for-loop to iterate through elements in the list. This hides an iterator: 

```
for (String hold: strings)
    System.out.println(hold)
```

List assumptions: 

+ Unbounded
+ Dulicate elements in a list
+ get and set are optional


## Array-based implementations: 

