public class GenericBox<T/* extends Number*/> {
    private T content;

    public void add(T content) {
        this.content = content;
    }

    public T get() {
        return content;
    }
}
