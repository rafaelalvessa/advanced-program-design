/**
 * The PolyTest class provides front-end code to test the implementation of
 * the class Poly.
 */
public class PolyTest {
    private static int pass, fail, nTests;

    public static void main(String[] args) throws NegativeExponentException {
        pass = 0;
        fail = 0;
        nTests = 0;
        Poly p1;
        Poly p2;

        // Tests the creation of a Poly().
        System.out.println("*** Test Poly() ***");
        p1 = new Poly();
        System.out.println("Polynomial: 0");
        System.out.println("Output: " + p1);
        printResult(p1.toString().equals("0"));

        // Tests the creation of a Poly(int m, int n).
        System.out.println("*** Test Poly(1, 0) ***");
        p1 = new Poly(1, 0);
        System.out.println("Polynomial: 1");
        System.out.println("Output: " + p1);
        printResult(p1.toString().equals("1"));

        System.out.println("*** Test Poly(4, 1) ***");
        p1 = new Poly(4, 1);
        System.out.println("Polynomial: 4x");
        System.out.println("Output: " + p1);
        printResult(p1.toString().equals("4x"));

        System.out.println("*** Test Poly(3, 2) ***");
        p1 = new Poly(3, 2);
        System.out.println("Polynomial: 3x^2");
        System.out.println("Output: " + p1);
        printResult(p1.toString().equals("3x^2"));

        System.out.println("*** Test Poly(2, -1) ***");
        System.out.println("Polynomial: 2x^(-1)");

        try {
            p1 = new Poly(2, -1);
        } catch (NegativeExponentException e) {
            System.out.println("Output: " + e.getClass() + ": " +
                    e.getMessage());
        }

        printResult(true);

        // Tests the degree() method.
        System.out.println("*** Test degree() for 3 ***");
        p1 = new Poly(3, 0);
        System.out.println("Polynomial: 3");
        System.out.println("Output: " + p1.degree());
        printResult(p1.degree() == 0);

        System.out.println("*** Teste degree() for 2x^3 ***");
        p1 = new Poly(2, 3);
        System.out.println("Polynomial: 2x^3");
        System.out.println("Output: " + p1.degree());
        printResult(p1.degree() == 3);

        System.out.println("*** Test degree() for 2x^3 + 5x ***");
        p1 = p1.add(new Poly(5, 1));
        System.out.println("Polynomial: 2x^3 + 5x");
        System.out.println("Output: " + p1.degree());
        printResult(p1.degree() == 3);

        // Tests the coeff(int d) method.
        System.out.println("*** Test coeff(3) ***");
        p1 = p1.add(new Poly(-7, 0));
        System.out.println("Polynomial: 2x^3 + 5x - 7");
        System.out.println("Output: " + p1.coeff(3));
        printResult(p1.coeff(3) == 2);

        System.out.println("*** Test coeff(2) ***");
        System.out.println("Polynomial: 2x^3 + 5x - 7");
        System.out.println("Output: " + p1.coeff(2));
        printResult(p1.coeff(2) == 0);

        System.out.println("*** Test coeff(1) ***");
        System.out.println("Polynomial: 2x^3 + 5x - 7");
        System.out.println("Output: " + p1.coeff(1));
        printResult(p1.coeff(1) == 5);

        System.out.println("*** Test coeff(0) ***");
        System.out.println("Polynomial: 2x^3 + 5x - 7");
        System.out.println("Output: " + p1.coeff(0));
        printResult(p1.coeff(0) == -7);

        System.out.println("*** Test coeff(-1) ***");
        System.out.println("Polynomial: 2x^3 + 5x - 7");
        System.out.println("Output: " + p1.coeff(-1));
        printResult(p1.coeff(-1) == 0);

        // Tests the add(Poly p) method.
        System.out.println("*** Test Poly().add(null) ***");
        try {
            p1 = new Poly();
            p1 = p1.add(null);
        } catch (NullPointerException e) {
            System.out.println("Output: " + e.getClass() + ": " +
                    e.getMessage());
        }
        printResult(true);

        System.out.println("*** Test Poly().add(new Poly(2, 1)) ***");
        p1 = new Poly();
        p1 = p1.add(new Poly(2, 1));
        System.out.println("Polynomial: 2x");
        System.out.println("Output: " + p1);
        printResult(p1.toString().equals("2x"));

        System.out.println("*** Test Poly(3, 2).add(new Poly(2, 2)) ***");
        p1 = new Poly(3, 2);
        p1 = p1.add(new Poly(2, 2));
        System.out.println("Polynomial: 5x^2");
        System.out.println("Output: " + p1);
        printResult(p1.toString().equals("5x^2"));

        System.out.println("*** Test Poly(5, 1).add(new Poly(2, 3)) ***");
        p1 = new Poly(5, 1);
        p1 = p1.add(new Poly(2, 3));
        System.out.println("Polynomial: 2x^3 + 5x");
        System.out.println("Output: " + p1);
        printResult(p1.toString().equals("2x^3 + 5x"));

        System.out.println("*** Test Poly(3, 2).add(new Poly(-2, 2)) ***");
        p1 = new Poly(3, 2);
        p1 = p1.add(new Poly(-2, 2));
        System.out.println("Polynomial: x^2");
        System.out.println("Output: " + p1);
        printResult(p1.toString().equals("x^2"));

        // Tests the sub(Poly p) method.
        System.out.println("*** Test Poly(-3, 1).sub(new Poly(4, 1)) ***");
        p1 = new Poly(-3, 1);
        p1 = p1.sub(new Poly(4, 1));
        System.out.println("Polynomial: -7x");
        System.out.println("Output: " + p1);
        printResult(p1.toString().equals("-7x"));

        System.out.println("*** Test Poly(-7, 1).sub(new Poly(-9, 1)) ***");
        p1 = p1.sub(new Poly(-9, 1));
        System.out.println("Polynomial: 2x");
        System.out.println("Output: " + p1);
        printResult(p1.toString().equals("2x"));

        System.out.println("*** Test Poly(2, 1).sub(new Poly(5, 3)) ***");
        p1 = p1.sub(new Poly(5, 3));
        System.out.println("Polynomial: -5x^3 + 2x");
        System.out.println("Output: " + p1);
        printResult(p1.toString().equals("-5x^3 + 2x"));

        // Tests the mult(Poly p) method.
        System.out.println("*** Test (3x + 2)(x + 6) ***");
        p1 = new Poly(3, 1);
        p1 = p1.add(new Poly(2, 0));
        p2 = new Poly(1, 1);
        p2 = p2.add(new Poly(6, 0));
        p1 = p1.mult(p2);
        System.out.println("Polynomial: 3x^2 + 20x + 12");
        System.out.println("Output: " + p1);
        printResult(p1.toString().equals("3x^2 + 20x + 12"));

        System.out.println("*** Test (3x^2 - 4x + 7)(6x + 2) ***");
        p1 = new Poly(3, 2);
        p1 = p1.add(new Poly(7, 0));
        p1 = p1.sub(new Poly(4, 1));
        p2 = new Poly(2, 0);
        p2 = p2.add(new Poly(6, 1));
        p1 = p1.mult(p2);
        System.out.println("Polynomial: 18x^3 - 18x^2 + 34x + 14");
        System.out.println("Output: " + p1);
        printResult(p1.toString().equals("18x^3 - 18x^2 + 34x + 14"));

        // Tests the minus() method.
        System.out.println("*** Test minus() for 18x^3 - 18x^2 + 34x + 14 ***");
        p1 = p1.minus();
        System.out.println("Polynomial: 18x^3 - 18x^2 + 34x + 14");
        System.out.println("Output: " + p1);
        printResult(p1.toString().equals("-18x^3 + 18x^2 - 34x - 14"));

        // Tests the equals(Object o) method.
        System.out.println("*** Test Poly().equals(null) ***");
        p1 = new Poly();
        System.out.println("Polynomial: 0");
        System.out.println("Output: " + p1.equals(null));
        printResult(!p1.equals(null));

        System.out.println("*** Test Poly().equals(new Object()) ***");
        System.out.println("Polynomial: 0");
        System.out.println("Output: " + p1.equals(new Object()));
        printResult(!p1.equals(new Object()));

        System.out.println("*** Test Poly(3, 2).equals(new Poly(3, 2)) ***");
        p1 = new Poly(3, 2);
        p2 = new Poly(3, 2);
        System.out.println("Polynomial: 3x^2");
        System.out.println("Output: " + p1.equals(p2));
        printResult(p1.equals(p2));

        // Tests the hashCode() method.
        System.out.println("*** Test Poly(3, 2).hashCode() ***");
        System.out.println("Polynomial: 3x^2");
        System.out.println("Output: " + p1.hashCode());
        printResult(true);

        // Final result
        System.out.println("Final result: " + pass + "/" + nTests);
    }

    /**
     * Prints the result of the test to the screen.
     *
     * @param test the boolean condition to test
     */
    private static void printResult(boolean test) {
        nTests++;

        if (test) {
            System.out.println("Result: Pass\n");
            pass++;
        } else {
            System.out.println("Result: Fail\n");
            fail++;
        }
    }
}
