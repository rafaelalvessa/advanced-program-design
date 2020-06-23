# A Polynomial Implementation

## Specifications

In the book 'Program Development in Java', Barbara Liskov gives an
implementation of the abstraction `Poly` using an array of integers. The
abstraction represents a polynomial expression of one variable. The operations
on it are as follows:

- A constructor to give a polynomial representing 0.
- A constructor taking two integers, `m` and `n`, which gives the polynomial
  representing `mx^n`.
- A method `degree` to give the degree of the polynomial it is called on
  (highest non- zero exponent).
- A method `coeff` which takes an integer `d` and returns the coefficient of the
  term of the polynomial it is called on whose exponent is `d`. So if `mx^n` is
  a term of the polynomial `p`, then `p.coeff(n)` returns `m`.
- A method `add` which takes a polynomial `p` and returns the polynomial
  obtained by adding `p` to the polynomial it is called on.
- A method `sub` which takes a polynomial `p` and returns the polynomial
  obtained by subtracting `p` from the polynomial it is called on.
- A method `mult` which takes a polynomial `p` and returns the polynomial
  obtained by multiplying `p` by the polynomial it is called on.
- A method `minus` which returns the result of subtracting the polynomial it is
  called on from 0.

The methods are all constructive, that is they return a new polynomial, they do
not alter the polynomial they are called on.

Liskov suggests the implementation chosen would be inefficient in the case of
sparse polynomials, that is polynomials with a few high value exponents but many
exponents below then having coefficients of 0. An alternative representation was
suggested, an array of coefficient/exponent pairs.

## Task

To write a full implementation of `Poly` using this suggested representation
suitable for sparse polynomials. Arrays must be used internally, not a
collection type like `Vector` or `ArrayList`.

Front-end code should be provided to show that the implementation is fully
tested.

A version of `equals` should also be provided for `Poly`, which overrides the
default `equals` inherited from `Object`.

## Running with Docker

```
$ docker build -t polynomial_implementation .
$ docker run -it --rm polynomial_implementation
```
