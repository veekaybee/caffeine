---
title:  Time Complexity and Java Basics
date: 2022-09-01
----

Each algorithm carries a cost in terms of performance over a given set of data
and a given datastructure. Time efficiency tells us how many times a given operation is 
performed so we can compare it across various hardware/software permutations equally.

[Big O Cheat sheet here](https://www.bigocheatsheet.com/)

In order of increasing complexity: 

| O(1)       |
|------------|
| O(log n)   |
| O(n)       |
| O(n log n) |
| O(n^2)     |
| O(2^n)     |
| O(n!)      |


## Primitive and non-primitive types
rimitive types are the basic data types that are built-in to the language and represent the simplest forms of data. They include the types boolean, char, byte, short, int, long, float, and double. These types are simple and cannot be further decomposed into other types.

Non-primitive types, on the other hand, are more complex types that are derived from the primitive types. They include arrays, classes, and interfaces, which are used to represent more complex data structures. Non-primitive types are also known as reference types, because they refer to objects that are stored in memory.

Examples of non-primitive types include String, ArrayList, and HashMap. These types are built from the primitive types and provide additional functionality and complexity. Unlike primitive types, non-primitive types can be decomposed into smaller parts and can be used to represent more complex data structures.

Primitive types in Java - handled by value - holds the actual value
Nonprimitive types - Handled by reference - holds the addreess to the file system

## By Value and by reference

When arguments are passed by value, the value of the argument is copied and passed to the function or method. This means that any changes made to the argument within the function or method do not affect the original value outside of the function. This is because the function or method is operating on a copy of the original value.

On the other hand, when arguments are passed by reference, a reference or pointer to the original argument is passed to the function or method. This means that any changes made to the argument within the function or method will affect the original value outside of the function, because the function or method is operating on the original value, rather than a copy.

In general, most programming languages pass primitive types (such as numbers and booleans) by value, while non-primitive types (such as objects and arrays) are passed by reference. This allows for flexibility and efficient memory usage, while still ensuring that the original values are not accidentally modified.


```java
public class Example {
  public static void main(String[] args) {
    // Declare a primitive int variable and initialize it to 5
    int primitiveInt = 5;
    // Call a method and pass the primitiveInt variable by value
    changeValueByValue(primitiveInt);
    // Print the value of primitiveInt after calling the method
    // It should still be 5, because primitive types are passed by value in Java
    System.out.println(primitiveInt);

    // Declare an object of type Person and initialize it with a name
    Person person = new Person("John");
    // Call a method and pass the person object by reference
    changeNameByReference(person);
    // Print the name of the person object after calling the method
    // It should be "Jane", because non-primitive types are passed by reference in Java
    System.out.println(person.getName());
  }

  // A method that takes an int argument and changes its value
  public static void changeValueByValue(int value) {
    value = 10;
  }

  // A method that takes a Person argument and changes its name
  public static void changeNameByReference(Person person) {
    person.setName("Jane");
  }
}

// A class representing a person with a name
class Person {
  private String name;

  public Person(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
```