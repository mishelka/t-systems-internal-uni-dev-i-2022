public class GenericBox<T> {
    private T content;

    public void add(T content) {
        this.content = content;
    }

    public T get() {
        return content;
    }
}
