public class TestGenericBox {
    public static void main(String[] args) {
        GenericBox<Integer> integerBox = new GenericBox<Integer>();

        //integerBox.add("10");
        Integer someInteger = integerBox.get();
        System.out.println(someInteger);
    }
}
