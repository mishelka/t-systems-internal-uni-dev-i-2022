package threads;

import java.util.Date;

public class SimpleThreadsTest2 {
    public static void main(String[] args) {
//        new Thread(new SimpleRunnable("Jamaica")).start();
//        new Thread(new SimpleRunnable("Fiji")).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello world!" + new Date());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }).start();

//        new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                System.out.println(i + " " + "Jamaica");
//                try {
//                    Thread.sleep((long) (Math.random() * 1000));
//                } catch (InterruptedException e) {
//                }
//            }
//            System.out.println("DONE! " + "Jamaica");
//        });

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    System.out.println(i + " " + "Jamaica");
//                    try {
//                        Thread.sleep((long) (Math.random() * 1000));
//                    } catch (InterruptedException e) {
//                    }
//                }
//                System.out.println("DONE! " + "Jamaica");
//            }
//        });
    }
}