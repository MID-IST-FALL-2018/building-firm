# Lab description

In this lab, your task is to write a program that models a small building firm.
The firm is composed by a team manger and several _n_ specialist workers such as mason, carpenter, electrician, plumber, etc.
The firm does not have much resources and can only build one house at a time.
They cannot start working on a new house until the present one is completed.
The team manager decides when the building process starts.
Moreover, the team manager must wait until all specialist tell him that they are done on this house before starting the team on the next house.
They never stop building houses.

# Architecture

Your task is to implement a program that models team manager and the workers of the firm.
Each of the members of the firm is modelled as a different Java thread.
Note that they must synchronise in order to work as described above.
In order to synchronise the workers with the manager you must use Monitors.
You must implement your own monitors in Java.

# Code Skeleton and Requirements

We provide a code skeleton with the following files that need to be completed:

## `BuildingFirm.java`

This file contains two inner classes extending from `Thread`: `TeamManager` and
`Worker`. These classes represent the team manager and the specialist,
respectively. Note that all specialist will behave the same, so their particular speciality is not relevant. Your task is to complete the method `run()` for each of this classes. The only constraint in here is the following:

* **Threads can only communicate using monitors from the `Monitor` class you implement (see below)**. No other variables can be shared.

* Workers can only work on one house at the same time.

* Workers can only start working if the team manager notifies them.

* The team manager must wait until all workers have finish working to start constructing a new house.

Note that the class also contains a `main(...)` method that starts `NUM_SPECIALISTS` worker threads and a team manager.


## `Monitor.java`

In this class your task is to implement a monitor with the following properties:

* All methods must be accessed in an atomic way.

* The monitor can only have two methods:
  * `enter()` to indicate that a thread wants to enter its critical section. This method may be blocking.
  * `leave()` to indicate that a thread is leaving its critical section.

You may use as many condition variables or local variables as you like in your monitor, but none of them can be accessed in `BuildingFirm.java`. They only two methods that can be used in `BuildingFirm.java` are `enter()` and `leave()`.

## Running the code

First compile both files with

```bash
$ javac *.java
```

and execute with

```bash
$ java BuildingFirm
```

An example of correct output is as follows:

```
Team manager tells to start working
Team manager waits for the workers to finish
Worker 12 is working
Worker 12 done
Worker 11 is working
Worker 11 done
Team manager tells to start working
Team manager waits for the workers to finish
Worker 12 is working
Worker 11 is working
Worker 11 done
Worker 12 done
Team manager tells to start working
Team manager waits for the workers to finish
Worker 12 is working
Worker 11 is working
Worker 12 done
Worker 11 done
```

Note that workers may work sequentially or concurrently but they always wait for the team manager to tell them to start.
