package examples;

class NameDropper1 implements StringTransformer {
    private String myName;

    public NameDropper1(String aName) {
        myName=aName;
    }

    public String transform(String thePhrase) {
        return myName + " says " + thePhrase;
    }
}
