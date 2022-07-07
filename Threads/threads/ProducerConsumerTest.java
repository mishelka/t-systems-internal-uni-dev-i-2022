package threads;

public class ProducerConsumerTest {
    public static void main(String[] args) {
        ExchangeBuffer c = new ExchangeBuffer();
        
        Producer p1 = new Producer("P1", c);
        Consumer c1 = new Consumer("C1", c);
        Producer p2 = new Producer("P2", c);
        Consumer c2 = new Consumer("C2", c);

        p1.start();
        c1.start();
        p2.start();
        c2.start();
    }
}
