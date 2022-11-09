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