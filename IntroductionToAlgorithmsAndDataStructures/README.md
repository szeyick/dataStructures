## Introduction to Algorithms and Data Structures

### Algorithms - 

An algorithm is defined as a procedure that takes a value or set of values and produces an output. It is a set of steps that convert an input into a particular output.

We use this in a computing context where the steps for an algorithm are performed by a machine. 

An example of this input and output relationship would be sorting a set of numbers. The sorting problem would be defined as follows -

- **Input** - 27, 45, 3, 9, 15, 1, 8
- **Output** - 1, 3, 8, 9, 15, 27, 45
 
The algorithm here would be the set of steps that would transform the unsorted input values into the sorted output values. 

### Algorithm Correctness

An algorithm is deemed as **correct** if for every piece of input, it provides the correct output. If an algorithm is not correct if it only provides the right answer for some input or none of the input. 

### Data Structures

A data structure is a way to store and organise data to allow easy access and modification of its contents. Depending on the type of problem, there can be many different data structures that can suit the purpose.

Real world examples of such data structures can be a rubbish bin, vending machine or a car stacker. Each of these structures can be used for different sorts of problems.

### Hard Problems (NP-Complete)

Algorithms are measured for their accuracy (correctness) along with their efficiency (time). Sometimes an algorithm can be correct but take an extremely long time to provide the right answer, which makes it inefficient and not particularly useful for an application. However there are some problems where there is no efficient solution, these such problems are called NP-Complete problem.

NP-Complete problems are problems where there has been no efficient solution found. They are unique problems because if there is an efficient solution for one NP-Complete problem, then there is a solution for all of the NP-Complete problems in the set. 

Also there are several NP-Complete problems that have similar properties to well known efficient algorithms, but small changes in the problem can cause a huge change in its efficiency of even the best known algorithms.

### Efficiency

Computers are fast, but are not infinitely fast, memory can be cheap but its not free. Because of this, computing time is bounded by these constraints (processing time and memory space) and should be used resourcefully. To ensure that we use as little processing time and memory space as possible, we need to learn about creating efficient algorithms.

Algorithms used to solve the same problem can differ dramatically in their efficiency depending on its implementation. An example of this would be with the two sorting algorithms **insertion sort** and **merge sort**.

Without diving into it into detail, the time taken for each algorithm to sort **n** items would be -

- **Insertion Sort** - Takes approximately c<sub>1</sub>n<sup>2</sup> time to sort n items.
- **Merge Sort** - Takes approximately c<sub>2</sub>n log<sub>2</sub> n to sort n items.
 
The value for c in the sorting algorithms is a constant value. These constant values are less significant as the value of n (size of input) grows. For smaller input sizes, insertion sort is faster than merge sort, but we will see that as the size of n grows larger, merge sort will generally be faster. 

If we have two computers, computer A running insertion sort and computer B running merge sort with the following specs

Computer A -
1. Executes 1 billion instructions per second.

Computer B -
1. Executes 10 million instructions per second.

And the size of the input we want to sort is 1 million numbers. Using the time taken for each algorithm to run as listed above, each computer will take the following time to sort 1 million numbers.

Computer A - 2000 seconds.
Computer B - 100 seconds.

### Algorithms, Hardware and System Design

Algorithms are only one aspect of system performance. Choosing the right algorithm to use is just as important as choosing the right hardware, GUI, and networking to go along with the application. Even if we have no use for an algorithm in an application, algorithms are used within the other components, they exist in almost all the core technologies within computers.
