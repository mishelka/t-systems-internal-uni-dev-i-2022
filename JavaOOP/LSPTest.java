
public class LSPTest {
    class ClassA {
        public String toString() {
            return "ClassA";
        }
    }

    class SubClassA extends ClassA {
        public String toString() {
            return "SubClassA";
        }
    }

    void testClassA(ClassA ca) {
        if ("ClassA".equals(ca.toString())) {
            System.out.println("Yes it is classA.");
        } else {
            System.out.println("Huh. It is not class classA!");
        }
    }

    public void test() {
        testClassA(new ClassA());
        testClassA(new SubClassA());
    }

    public static void main(String[] args) {
        new LSPTest().test();
    }
}
