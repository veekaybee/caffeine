---
title: Binary Search Tree ADT
date: 2022-11-01
----

Trees are a variation on collections (which have add, remove, get, and contains operations)
that maintains elements in increasing order and provides
efficient implementations of all the core operations.

tree is a nonlinear structure in which each node is capable of having many successor nodes, called children.

- Binary tree: A tree in which each node is capable of having two child nodes, a left child node and a right child node


A binary search tree maintains elements in increasing order 
and provides efficient access to operations. 

A binary tree in which the key value in any node is greater than or equal to the key value in its left child and any of its descendants (the nodes in the left subtree) 
is less than the key value in its right child and any of its descendants (the nodes in the right subtree)


Binary Search Tree, in general allows O(log2N) find location , O(1) insertion


Example:
```
         2               
        / \       
       /   \      
      /     \     
     /       \    
     7       5       
    / \     / \   
   /   \   /   \  
   2   6   3   6   
  / \ / \ / \ / \ 
  5 8 4 5 8 4 5 8 
```


``java
import ch05.collections.CollectionInterface;
import java.util.Iterator;

public interface BSTInterface<T> extends CollectionInterface<T>, Iterable<T>
{
  // Used to specify traversal order.
  public enum Traversal {Inorder, Preorder, Postorder};

  T min();
  // If this BST is empty, returns null;
  // otherwise returns the smallest element of the tree.

  T max();
  // If this BST is empty, returns null;
  // otherwise returns the largest element of the tree.
  
  public Iterator<T> getIterator(Traversal orderType);
  // Creates and returns an Iterator providing a traversal of a "snapshot" 
  // of the current tree in the order indicated by the argument.
}``