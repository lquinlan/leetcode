import java.util.concurrent.CountDownLatch;

public class Foo2 {
    CountDownLatch s1, s2;

    public Foo2() {
        s1 = new CountDownLatch(1);
        s2 = new CountDownLatch(1);

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s1.countDown();
        ;
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        s1.await();
        ;
        printSecond.run();
        s2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        s2.await();
        printThird.run();
    }

}
