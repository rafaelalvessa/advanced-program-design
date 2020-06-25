package examples;

class UpperCaser2 implements Transformer<String, String> {
    public String transform(String thePhrase) {
        return thePhrase.toUpperCase();
    }
}
