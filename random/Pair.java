package random;

public class Pair<T, Q> {
    public T p1;
    public Q p2;

    public Pair(T a, Q b) {
        this.p1 = a;
        this.p2 = b;
    }

    public Q getValue() {
        return this.p2;
    }

    public T getKey() {
        return this.p1;
    }
}