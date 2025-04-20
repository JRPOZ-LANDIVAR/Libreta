

public class Nodo<T> {
    protected T value;
    protected Nodo<T> left;
    protected Nodo<T> right;

    public Nodo(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("(%s) [left: %s] [right: %s]",
                value,
                left != null ? left.value : "null",
                right != null ? right.value : "null");
    }
}
