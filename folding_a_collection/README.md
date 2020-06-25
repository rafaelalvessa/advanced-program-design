# Folding a Collection

## Specifications

The `src/examples/` directory constains a few examples of a 'functional'
approach to programming in Java. The idea is to generalise a method by making a
'function object' a parameter to it. The most obvious example is when an object
of type `Comparator<T>` is passed as an argument to a sort method or to some
other method which relies on a collection being ordered. This object does the
comparisons between items in the collection, and so may be varied to give
ordering on different criteria, rather than have the ordering fixed by the type
of object in the collection.

In order to illustrate the principle, rather than use the interface
`Comparator<T>` from the Java library, similar interfaces are defined and
extended. Another case of using a 'function object' is also given, a map
operation which takes a collection and returns a collection obtained by applying
a particular function to every item in the original collection.

Another generalised operation on collections of data is called `fold`. This
operation takes a collection of objects and an object whose only role is to give
a function, `join`, which takes two objects and returns an object. The operation
`fold` joins all the items in the collection together using this function.

This is perhaps better understood by considering some examples. Suppose our
`join` function adds two integers. Then the result of `fold` with its arguments
a function object with this `join` function, and a collection of integers of
length `n` referred to by `c` is `c.get(0) + c.get(1) + ... + c.get(n - 1)`,
that is the sum of the integers in the collection. If the `join` function
multiplies two integers the result of the fold on a collection of integers is to
give the product of the integers in the collection. If the `join` function
returns the largest of two integers, the fold operation will return the largest
integer from the whole collection. If the `join` operation takes two strings and
returns whichever is the longest, and the collection contains strings, then the
fold operation will return the longest string from the whole collection.

All the above examples assume the `join` operation takes two arguments of the
same type, returns a value of the same type, and is associative, meaning that
`join(x,join(y,z))` always gives the same as `join(join(x,y),z)`. However, that
need not be the case. Suppose the `join` operation takes an argument of type `T`
and an argument of type `S` and returns a value of type `S`. Then the `fold`
operation can be defined such that taking a collection of items of type `T` with
the collection referred to by `c`, it returns a result of type `S` given by:

```
join(c.get(0), join(c.get(1), join(..., join(c.get(n - 1), s)...)))
```

Here, `s` is a value of type `S` which is needed as a third argument to the fold
operation. Another way of thinking of this `fold` is that it is a recursive
operation. In this definition, `fold` returns `s` if its collection argument is
the empty collection, otherwise it returns the `join` function applied to the
item at position 0 and the result of folding the collection consisting of all
but the item at position 0 with the join object and `s` as the other arguments.

For example, suppose we have a `join` operation which takes an integer and a
string and returns whichever is the larger: the integer it takes or the length
of the String it takes. So here we have `T` as the type String, and `S` as the
type Integer in Java. If the fold method is called with a function object giving
this `join` as its joiner argument, a collection of strings as its collection
argument, and 0 as its `s` argument, it will return the length of the longest
string in the collection.

As another example, suppose that `s` is the empty list (that is, a list of size
0) and the `join` operation takes an integer and a list of integers in numerical
order, and returns a new ordered list of integers consisting of all the integers
from the list argument plus the integer argument inserted in ordered position.
We can make it a prerequisite of the `join` operation here that the list it
takes is ordered, so it does not have to test for ordering or do any sorting
itself. As `s` is the empty list (which is by its nature ordered), and the
`join` operation gives an ordered list under the assumption the list passed to
it was in order, each call of `join` will give an ordered list, and the final
call will give a list which contains all the integers from the original
collection, but in order. So the result of the `fold` is to sort the original
collection of integers passed to it as an argument.

So we can see here that fold is a very generalised operation on collections. We
can specialise it to perform various common operations by what we set as its
argument to provide the `join` operation. If the collection is a collection of
integers, `fold` can return the sum, the product, the maximum integer of the
collection, or even the elements of the collection in a list in numerical order,
depending only on the `join` operation passed to it.

Note that strictly the `fold` operation given here is 'fold right'. An
alternative form of `fold`, 'fold left' gives:

```
join(join(...join(join(s,c .get(0)), c.get(1))...), c.get(n - 2)), c.get(n - 1))
```

where the `join` operation takes an argument of type `S` and an argument of type
`T` and returns an item of type `S`, and the `fold` operation is applied to a
collection of items of type `T`.

## Task

To implement `fold`, and a range of `join` operations. The `join` operations
should include the operation to add two integers, the operation to return the
maximum of two integers, the operation described above which takes an integer
and a string and returns an integer, and the operation to return the result of
inserting an integer into the correct position in an ordered list of integers.

The code must show correct use of Java's generic types throughout. It is
important to understand that there should be just one method for `fold`, and
that method itself does not require any kind of type checking or casting or
converting any objects from one type to another.

## Running with Docker

```
$ docker build -t folding_a_collection .
$ docker run -it --rm folding_a_collection java MyFold
$ docker run -it --rm folding_a_collection java examples/Sort1
$ docker run -it --rm folding_a_collection java examples/Sort2
$ docker run -it --rm folding_a_collection java examples/Sort3
$ docker run -it --rm folding_a_collection java examples/Sort4
$ docker run -it --rm folding_a_collection java examples/Sort5
$ docker run -it --rm folding_a_collection java examples/StringTransform1
$ docker run -it --rm folding_a_collection java examples/StringTransform2
$ docker run -it --rm folding_a_collection java examples/StringTransform3
$ docker run -it --rm folding_a_collection java examples/StringTransform4
$ docker run -it --rm folding_a_collection java examples/StringTransform5
```
