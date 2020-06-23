/**
 * The class Poly implements the representation of a polynomial expression
 * of one variable.
 */
public class Poly {
    /* An array containing the pairs (coefficient and exponent) of all the
     * terms of a polynomial.
     */
    private Pair[] terms;

    /**
     * A pair contains the coefficient and exponent of a polynomial term.
     */
    private static class Pair {
        int coefficient;
        int exponent;
    }

    /**
     * A constructor to give a polynomial representing 0.
     */
    public Poly() {
        terms = new Pair[1];
        terms[0] = new Pair();
        terms[0].coefficient = 0;
        terms[0].exponent = 0;
    }

    /**
     * A constructor taking two integers, which gives the polynomial
     * representing mx^n.
     *
     * @param m the coefficient of the polynomial
     * @param n the exponent of the polynomial
     * @throws NegativeExponentException if the exponent is a negative number
     */
    public Poly(int m, int n) throws NegativeExponentException {
        if (n < 0)
            throw new NegativeExponentException("Poly(int m, int n): n < 0");

        terms = new Pair[1];
        terms[0] = new Pair();
        terms[0].coefficient = m;
        terms[0].exponent = n;
    }

    /**
     * A constructor taking an array of pairs (terms), which allows to create a
     * polynomial with more than just one term.
     *
     * @param p the array containing all the terms of the polynomial
     */
    private Poly(Pair[] p) {
        terms = p;
    }

    /**
     * Gives the degree of the polynomial it is called on (highest non-zero
     * exponent).
     *
     * @return the highest non-zero exponent
     */
    public int degree() {
        return terms[0].exponent;
    }

    /**
     * Returns the coefficient of the term of the polynomial whose exponent
     * is d. For mx^n, where n equals d, it returns m.
     *
     * @param d the exponent of the term of the polynomial
     * @return the coefficient of the term of the polynomial whose exponent is d
     */
    public int coeff(int d) {
        if (d < 0 || d > this.degree())
            return 0;

        for (int i = 0; i < terms.length; i++) {
            if (terms[i].exponent == d)
                return terms[i].coefficient;
        }

        return 0;
    }

    /**
     * Takes a polynomial p and returns a new polynomial obtained by adding p
     * to the polynomial it is called on.
     *
     * @param p the polynomial to add
     * @return a new polynomial obtained by adding p to this polynomial
     */
    public Poly add(Poly p) {
        if (p.equals(null))
            throw new NullPointerException("add(Poly p): p == null");

        // The highest degree of the two polynomials.
        int highest = (this.degree() > p.degree()) ? this.degree() : p.degree();

        // An array with enough space for all terms with non-zero coefficients.
        Pair[] newTerms = new Pair[countTerms(p, highest, 0)];

        int nthTerm = 0;
        int sum = 0;

        for (int i = highest; i >= 0; i--) {
            sum = this.coeff(i) + p.coeff(i);
            if (sum != 0) {
                newTerms[nthTerm] = new Pair();
                newTerms[nthTerm].coefficient = sum;
                newTerms[nthTerm].exponent = i;
                nthTerm++;
            }
        }

        return new Poly(newTerms);
    }

    /**
     * Takes a polynomial p and returns a new polynomial obtained by
     * subtracting p from the polynomial it is called on.
     *
     * @param p the polynomial to subtract
     * @return a new polynomial obtained by subtracting p from this polynomial
     */
    public Poly sub(Poly p) {
        if (p.equals(null))
            throw new NullPointerException("sub(Poly p): p == null");

        // The highest degree of the two polynomials.
        int highest = (this.degree() > p.degree()) ? this.degree() : p.degree();

        // An array with enough space for all terms with non-zero coefficients.
        Pair[] newTerms = new Pair[countTerms(p, highest, 1)];

        int nthTerm = 0;
        int sub = 0;

        for (int i = highest; i >= 0; i--) {
            sub = this.coeff(i) - p.coeff(i);
            if (sub != 0) {
                newTerms[nthTerm] = new Pair();
                newTerms[nthTerm].coefficient = sub;
                newTerms[nthTerm].exponent = i;
                nthTerm++;
            }
        }

        return new Poly(newTerms);
    }

    /**
     * Counts the number of terms with non-zero coefficients after adding or
     * subtracting the coefficients of both polynomials.
     *
     * @param p the polynomial to add or subtract
     * @param degree the highest degree of the two polynomials
     * @param option 0 for sum; 1 for subtraction
     * @return the number of terms with non-zero coefficients
     */
    private int countTerms(Poly p, int degree, int option) {
        int nTerms = 0;
        for (int i = degree; i >= 0; i--) {
            // When adding two polynomials.
            if (option == 0 && (this.coeff(i) + p.coeff(i) != 0)) {
                nTerms++;
            // When subtracting two polynomials.
            } else if (option == 1 && (this.coeff(i) - p.coeff(i) != 0)) {
                nTerms++;
            }
        }
        return nTerms;
    }

    /**
     * Takes a polynomial p and returns a new polynomial obtained by
     * multiplying p from the polynomial it is called on.
     *
     * @param p the polynomial to multiply
     * @return a new polynomial obtained by multiplying p by this polynomial
     * @throws NegativeExponentException if the exponent is a negative number
     */
    public Poly mult(Poly p) throws NegativeExponentException {
        if (p.equals(null))
            throw new NullPointerException("mult(Poly p): p == null");

        // An array with all terms of both polynomials multiplied.
        Pair[] allMultTerms = new Pair[terms.length * p.terms.length];

        /* Multiplies the terms of all polynomials and adds each of them to
         * the allMultTerms array.
         */
        int nthTerm = 0;
        for (int i = 0; i < terms.length; i++) {
            for (int j = 0; j < p.terms.length; j++) {
                allMultTerms[nthTerm] = new Pair();
                allMultTerms[nthTerm].coefficient = terms[i].coefficient *
                p.terms[j].coefficient;
                allMultTerms[nthTerm].exponent = terms[i].exponent +
                p.terms[j].exponent;
                nthTerm++;
            }
        }

        Poly newTerms = new Poly();

        // Sums all the terms of the polynomial.
        for (int k = 0; k < allMultTerms.length; k++) {
            newTerms = newTerms.add(new Poly(allMultTerms[k].coefficient,
            allMultTerms[k].exponent));
        }

        return newTerms;
    }

    /**
     * Returns a new polynomial obtained by subtracting the polynomial it is
     * called on from 0.
     *
     * @return a new polynomial obtained by subtracting this polynomial from 0
     */
    public Poly minus() {
        int length = this.terms.length;
        Pair[] newTerms = new Pair[length];

        for (int i = 0; i < length; i++) {
            newTerms[i] = new Pair();
            newTerms[i].coefficient = - terms[i].coefficient;
            newTerms[i].exponent = terms[i].exponent;
        }

        return new Poly(newTerms);
    }

    /**
     * Returns a String representing the polynomial expression.
     */
    public String toString() {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < terms.length; i++) {
            // Takes care of the '+' and '-' symbols.
            if (i == 0 && terms[i].coefficient < 0)
                output.append("-");
            else if (i > 0 && terms[i].coefficient < 0)
                output.append(" - ");
            else if (i > 0 && terms[i].coefficient > 0)
                output.append(" + ");

            // Takes care of the coefficient values.
            if (terms[i].exponent == 0 || terms[i].coefficient != 1)
                output.append(Math.abs(terms[i].coefficient));

            // Takes care of the exponents.
            if (terms[i].exponent == 1)
                output.append("x");
            else if (terms[i].exponent > 1)
                output.append("x^" + terms[i].exponent);
        }

        return output.toString();
    }

    /**
     * Compares this Poly to the specified object.
     *
     * @param o the object to compare this Poly against
     * @return true if both objects are equivalent; false otherwise
     */
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Poly))
            return false;

        Poly p = (Poly) o;

        if (terms.length != p.terms.length)
            return false;
        if (this.degree() != p.degree())
            return false;

        for (int i = 0; i < terms.length; i++) {
            if ((terms[i].coefficient != p.terms[i].coefficient) ||
            (terms[i].exponent != p.terms[i].exponent))
                return false;
        }

        return true;
    }

    /**
     * Returns a hash code for this Poly object.
     *
     * @return a hash code value for this object
     */
    public int hashCode() {
        int result = 17;

        for (int i = 0; i < terms.length; i++)
            result = result * 37 + terms[i].coefficient + terms[i].exponent;

        return result;
    }
}
