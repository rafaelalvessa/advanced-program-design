package examples;

class NameDropper2 implements Transformer<String,String> {
    private String myName;

    public NameDropper2(String aName) {
        myName=aName;
    }

    public String transform(String thePhrase) {
        return myName + " says " + thePhrase;
    }
}
