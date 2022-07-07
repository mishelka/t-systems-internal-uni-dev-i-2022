public class TestBox {
    public static void main(String[] args) {
        IntegerBox integerBox = new IntegerBox();
        integerBox.add(10);
        Integer someInteger = (Integer)integerBox.get();
        System.out.println(someInteger);
    }
}
