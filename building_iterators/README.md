# Building Iterators

## Specifications

The class `MySet` implements a generic set in a similar way to the set of
integers implemented in Chapter 5 of the Liskov book (page 88). There is also a
simple front end to test it in the class `UseStringSets1`, where a
`MySet<String>` object is created and manipulated. The main method in this class
presents a simple system in which there is a set (initially empty) to which
strings  can  be  inserted  and  removed. Enter  the  command `i` followed by
the strings  you  wish  to  insert  (separated  by  spaces),  or `r` followed by
the  strings  you  wish  to remove. Enter `p` to print a representation of the
set, `s` to print the size of the set, `m` followed by a list of strings to test
their membership, and `q` to quit. The front end in `UseIntSets1` is the same,
except it creates and manipulates a `MySet<Integer>` object.

## Task

To implement an iterator to go in the `MySetclass`. The implementation of an
iterator for the class `Poly` found on page 135 of the Liskov book shows an
example (although it does not use generics, your code should).

An iterator must generate an object of a class which implements Java's
`Iterator<E>` interface:

```
interface Iterator<E> {
    public boolean hasNext();

    public E next();

    void remove();
}
```

The method `remove()` is optional; for the purpose of this exercise you should
implement it with a method that always throws the appropriate exception:

```
public void remove() {
    throw new UnsupportedOperationException();
}
```

The idea is that a method `iterator()` is added to class `MySet<E>` which
returns an object of a subclass of `Iterator<E>`. Each time `next()` is called
on that object, an item from the `MySet` object it was derived from is returned
until all have been returned exactly once. The method `hasNext()` returns
`false` if all elements have been returned by `next()`, `true` otherwise. If
`next()` is called when `hasNext()` would return `false`, the exception
`NoSuchElementException` is thrown. It is acceptable to make it a requirement
that the original `MySet` object is not modified while there are still elements
to be returned.

You have to write your own class which implements `Iterator<E>`; you are not
permitted just to write your method `iterator()` as returning the result of
calling `iterator()` on the `ArrayList` inside a `MySet` object.

Next, an iterator which produces a filtered run through the elements of a
`MySet` object must be implemented. The criterion for filtering should be
expressed by a parameter of type `Checker<E>` given by the interface:

```
interface Checker<E> {
    public boolean check(E obj);
}
```

Only objects from the original collection where the test `check(obj)` succeeds
should be returned by the `next()` operation.

Suppose, for example, that the check in a `Checker<String>` object is that only
strings of length over 3 return `true`. Then the iterator with this object as
its argument would return an `Iterator` object which returns, on each `next()`
call, only those elements from the `MySet<String>` object it is based on whose
length is over 3.

The recommended way of implementing this is that your filter object should be
produced from a separate class called `Filter<E>` whose constructor takes an
object of class `Iterator<E>` (which would be here the normal iterator for the
set) and an object of class `Checker<E>` and returns an object of type
`Iterator<E>` which gives the filtered iteration.

So let us assume the call new `LongerThan(3)` returns a new `Checker<String>`
object where `check(str)` returns `true` if `str` refers to a string of length
longer than 3, `false` otherwise. Let us assume set refers to the set of strings
written textually:

```
{twas, brillig, and, the, slithy, toves, did, gyre, gimble, in, wabe}
```

Then the desired object referenced by variable `it` produced by:

```
Iterator<String> it1 = set.iterator();
Iterator<String> it = new Filter(it1, new LongerThan(3));
```

The strings returned by the calls of `next()` on the object are "twas",
"brillig", "slithy", "toves", "gyre", "gimble" and "wabe", although not
necessarily in that order.

The front end in `UseStringSets2` will enable you to check this by setting up a
set of strings, creating an `Iterator<String>` object from it, then a
`Filter<String>` object using that and a `LongerThan` object. Also, the front
end in `UseIntSets2` shows a `Filter<Integer>` object used to create an
`Iterator<Integer>` object which only gives the odd integers from a set of
integers.

## Running with Docker

```
$ docker build -t building_iterators .
$ docker run -it --rm building_iterators java UseIntSets1
$ docker run -it --rm building_iterators java UseIntSets2
$ docker run -it --rm building_iterators java UseStringSets1
$ docker run -it --rm building_iterators java UseStringSets2
```
