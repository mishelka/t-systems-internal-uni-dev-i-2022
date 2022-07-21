public class TestGenericBox {
    public static void main(String[] args) {
        GenericBox<Integer> integerBox = new GenericBox<>();

        integerBox.add(10);
        Integer someInteger = integerBox.get();
        System.out.println(someInteger);

        GenericBox<String> stringBox = new GenericBox<>();

        stringBox.add("10");
        String someString = stringBox.get();
        System.out.println(someString);
    }
}
