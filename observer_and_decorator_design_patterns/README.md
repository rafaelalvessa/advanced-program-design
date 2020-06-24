# The Observer and Decorator Design Patterns

## Specifications

The interface `Observer` and the class `Observable`, which are provided in the
Java code library, directly implement the 'Observer' design pattern. This is one
of the classic design patterns, which develops further into the
Model-View-Controller framework used for event modelling.

The documentation for `Observer` and `Observable` exist on Sun's Java website at
http://java.sun.com/javase/7/docs/api/index.html.

The basic idea is that objects of a subtype of `Observable` are linked with
objects of a subtype of `Observer` such that when certain pieces of code are
executed in the `Observable` objects a method is called in the linked `Observer`
object or objects.

## Task

To create observers of `DogBot` objects as given for the week 2 teaching.
Create a class `DogWatcher` which implements `Observer`. A `DogWatcher` object
should react by printing a message whenever a `DogBot` object to which it is an
observer executes a method which causes its state to change  `DogBot` should
also be amended so that `DogBot` objects have individual names, and give them a
`toString` method which returns their names.

One way of doing this would be to make further changes the code of the class
`DogBot` in order to make a `DogBot` object a type of `Observable` object.
However, as a better solution, instead of further amending the class `DogBot`,
write a class which creates an observable `DogBot` by using the `Decorator`
design pattern to add the observable aspects of the `DogBot` methods to `DogBot`
objects.

Make an example program in which two `DogBot` and two `DogWatcher` objects are
created, and the `DogBot` objects are made observable. The program should then
demonstrate `DogWatcher` objects being added to and taken away from the list of
observers of `DogBot` objects. `DogWatcher` objects also have names, so the
program should print messages such as

```
Henry observes Patch play
```

where `Henry` is the name of a `DogWatcher` object and `Patch` is the name of a
`DogBot` object.

Also amend the class `RacingDogBot` so that `DogWatcher` objects may correctly
observe the actions of `RacingDogBot` objects, and write code to test
`DogWatcher` objects observing `RacingDogBot` objects.

Note, it is expected to use Java’s library code for `Observer` and `Observable`
in this exercise; you should not write your own code for the methods given to
you in class `Observable`, nor should you write your own interface `Observer`.

## Running with Docker

```
$ docker build -t observer_and_decorator_design_patterns .
$ docker run -it --rm observer_and_decorator_design_patterns
```
