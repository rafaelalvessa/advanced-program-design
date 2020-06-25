package examples;

class UpperCaser1 implements StringTransformer {
    public String transform(String thePhrase) {
        return thePhrase.toUpperCase();
    }
}
