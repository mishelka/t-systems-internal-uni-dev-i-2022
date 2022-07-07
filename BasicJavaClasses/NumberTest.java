
public class NumberTest {
    public static void main(String[] args) {
        System.out.println("byte minvalue = " + Byte.MIN_VALUE + " maxvalue = " + Byte.MAX_VALUE);
        System.out.println("short minvalue = " + Short.MIN_VALUE + " maxvalue = " + Short.MAX_VALUE);
        System.out.println("int minvalue = " + Integer.MIN_VALUE + " maxvalue = " + Integer.MAX_VALUE);
        System.out.println("long minvalue = " + Long.MIN_VALUE + " maxvalue = " + Long.MAX_VALUE);

        int value = 128;
        System.out.println("BinaryString = " + Integer.toBinaryString(value));
        System.out.println("OctalString = " + Integer.toOctalString(value));
        System.out.println("HexString = " + Integer.toHexString(value));

        for (int radix = 2; radix <= 16; radix++) {
            System.out.println("ToRadix (radix = " + radix + ") " + Integer.toString(value, radix));
        }
    }
}
