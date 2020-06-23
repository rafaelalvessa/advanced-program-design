FROM openjdk:7
COPY ./src /usr/src/polynomial_implementation
WORKDIR /usr/src/polynomial_implementation
RUN javac NegativeExponentException.java Poly.java PolyTest.java
CMD ["java", "PolyTest"]
