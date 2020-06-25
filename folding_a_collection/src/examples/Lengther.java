package examples;

class Lengther implements Transformer<String, Integer> {
    public Integer transform(String str) {
        return str.length();
    }
}
