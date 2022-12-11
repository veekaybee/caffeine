---
title:  Stacks
date: 2022-09-15
----
Abstract data type (ADT)  - A data type whose properties (domain and operations) are specified independently of any particular implementation


A stack is a first-in first-out abstract data type - elements are added and removed from only one end

Elements of stacks: 
```Constructor
new - creates an empty stack
Transformers
push - adds an element to the top of a stack 
pop - removes the top element off the stack 
Observer
top - returns the top element of a stack
```

e.g. Operating systems save information about the current process on a stack, so that it can work on a higher-priority, interrupting process 


 

Sample Stack implementation: 

```java
public class ArrayBoundedStack<T> implements StackInterface<T> 
{
  protected final int DEFCAP = 100; // default capacity
  protected T[] elements;           // holds stack elements
  protected int topIndex = -1;      // index of top element in stack

  public ArrayBoundedStack() 
  {
    elements = (T[]) new Object[DEFCAP];
  }

  public ArrayBoundedStack(int maxSize) 
  {
    elements = (T[]) new Object[maxSize];
  }

  public void push(T element)
  // Throws StackOverflowException if this stack is full,
  // otherwise places element at the top of this stack.
  {      
    if (isFull())
      throw new StackOverflowException("Push attempted on a full stack.");
    else
    {
      topIndex++;
      elements[topIndex] = element;
    }
  }

  public void pop()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise removes top element from this stack.
  {                  
    if (isEmpty())
      throw new StackUnderflowException("Pop attempted on an empty stack.");
    else
    {
      elements[topIndex] = null;
      topIndex--;
    }
  }

  public T top()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise returns top element of this stack.
  {                 
    T topOfStack = null;
    if (isEmpty())
      throw new StackUnderflowException("Top attempted on an empty stack.");
    else
      topOfStack = elements[topIndex];
    return topOfStack;
  }

  public boolean isEmpty()
  // Returns true if this stack is empty, otherwise returns false.
  {              
    return (topIndex == -1); 
  }

  public boolean isFull()
  // Returns true if this stack is full, otherwise returns false.
  {              
    return (topIndex == (elements.length - 1));
  }
}

// And caller class: 

import java.util.Arrays;
import java.util.Scanner;
import ch02.stacks.ArrayBoundedStack;


public class EditString {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Input strings
        String inputString = null;
        String currentString = null;
        String expression = null;

        final String STOP = "X";

        System.out.print("\nEnter string: ");
        inputString = scan.nextLine();
        currentString = inputString;



        ArrayBoundedStack<String> stringStack = new ArrayBoundedStack<>(10);
        stringStack.push(currentString);


        System.out.print("\nEnter commands U,L,R, [C 1 2], Z or (" +  STOP + " to stop): ");
        expression = scan.nextLine();


        while (!STOP.equals(expression)){
            if ("Z".equals(expression)){
                System.out.println("Entered Z, undoing last move: ");
                System.out.println(expression);
                stringStack.pop();
                System.out.println("Evaluated expression: " +  stringStack.top() );
                expression = scan.nextLine();
            }
            else {
                System.out.println("Entered Command: " + expression);
                currentString = EditStringEvaluator.evaluate(stringStack.top(), expression);
                stringStack.push(currentString);
                System.out.println("Evaluated expression: " +  currentString);
                expression = scan.nextLine();
            }
        }


        System.out.println(currentString);



    }
}
```