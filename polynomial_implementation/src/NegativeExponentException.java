/**
 * Thrown to indicate that the exponent of one of the terms of the polynomial
 * is a negative number.
 */
public class NegativeExponentException extends Exception {
    String message;

    /**
     * Constructs a NegativeExponentException class with no detail message.
     */
    public NegativeExponentException() {
        super();
    }

    /**
     * Constructs a NegativeExponentException class with the specified detail
     * message.
     *
     * @param msg the detail message
     */
    public NegativeExponentException(String msg) {
        super(msg);
        message = msg;
    }
}
